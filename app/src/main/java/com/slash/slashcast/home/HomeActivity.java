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
import com.slash.slashcast.home.rvSubject.RvSubjectAdapter;
import com.slash.slashcast.home.rvSubject.RvSubjectModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    RecyclerView recyclerView;
    private RvChapterViewModel rvChapterViewModel;
    RvChapterAdapter rvChapterAdapter;
    RvSubjectAdapter rvSubjectAdapter;

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

        rvChapterAdapter = new RvChapterAdapter();

        recyclerView = binding.rvHome;
        rvChapterViewModel = ViewModelProviders.of(this).get(RvChapterViewModel.class);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        getAllChapters();
        rvSubjectAdapter = new RvSubjectAdapter();
        recyclerView.setAdapter(rvSubjectAdapter);

    }

    private void getAllChapters() {
        rvChapterViewModel.getAllChapter().observe(this, rvChapterDetails -> {
            rvChapterAdapter.setChapterList((ArrayList<RvChapterDetail>) rvChapterDetails);
            ArrayList<RvSubjectModel> subjectList = new ArrayList<>();
            String[] title = new String[] {
                    "Newest","Free","Popular","Most visited"
            };
            for (int i = 0; i < 4; i++) {
                RvSubjectModel model = new RvSubjectModel(title[i],(ArrayList<RvChapterDetail>) rvChapterDetails);
                subjectList.add(model);
            }
            rvSubjectAdapter.setList(subjectList);
        });
    }
}