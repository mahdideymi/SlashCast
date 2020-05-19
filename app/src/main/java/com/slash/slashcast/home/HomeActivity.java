package com.slash.slashcast.home;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.slash.slashcast.R;
import com.slash.slashcast.databinding.ActivityHomeBinding;
import com.slash.slashcast.home.rvChapter.RvChapterAd;
import com.slash.slashcast.home.rvChapter.RvChapterAdapter;
import com.slash.slashcast.home.rvChapter.RvChapterDetail;
import com.slash.slashcast.home.rvChapter.RvChapterViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    RecyclerView recyclerView;
    private RvChapterViewModel rvChapterViewModel;
    RvChapterAdapter rvChapterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        ImageView avatar = binding.profileSrcHome;

        Glide.with(HomeActivity.this).load("https://source.unsplash.com/100x100/?face")
                .centerCrop()
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
//                .skipMemoryCache(true)
                .placeholder(R.drawable.btn).dontAnimate().into(avatar);

        recyclerView = binding.rvHome;
        rvChapterViewModel = ViewModelProviders.of(this).get(RvChapterViewModel.class);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);
        rvChapterAdapter = new RvChapterAdapter();
        recyclerView.setAdapter(rvChapterAdapter);
        getAllChapters();

    }

    private void getAllChapters() {
        rvChapterViewModel.getAllChapter().observe(this, rvChapterDetails -> {
            rvChapterAdapter.setChapterList((ArrayList<RvChapterDetail>) rvChapterDetails);
        });
    }
}