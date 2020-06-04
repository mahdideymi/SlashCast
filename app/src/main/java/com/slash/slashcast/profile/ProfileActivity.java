package com.slash.slashcast.profile;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.slash.slashcast.Application;
import com.slash.slashcast.R;
import com.slash.slashcast.profile.fragments.DownloadFragment;

public class ProfileActivity extends DialogFragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ProfileTabAdapter adapter;
    private ImageView profileAvatar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.FullScreenDialog);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_profile , container , false);

        init(view);

        view.findViewById(R.id.profileBack).setOnClickListener(view1 -> dismiss());

        Glide.with(Application.getContext())
                .load("https://source.unsplash.com/100x100/?man")
                .placeholder(R.drawable.placeholder)
                .skipMemoryCache(false)
                .into(profileAvatar);

        adapter.addFragment(new DownloadFragment(), "Bought");
        adapter.addFragment(new DownloadFragment(), "Favorite");
        adapter.addFragment(new DownloadFragment(), "Download");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    private void init(View view) {
        viewPager = view.findViewById(R.id.profilePager);
        tabLayout = view.findViewById(R.id.profileTab);
        profileAvatar = view.findViewById(R.id.profilePic);
        adapter = new ProfileTabAdapter(getChildFragmentManager() , 0);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDialog().getWindow()
                .getAttributes().windowAnimations = R.style.DialogAnimation;
    }

    @Override
    public int getTheme() {
        return R.style.FullScreenDialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null)
        {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }
}
