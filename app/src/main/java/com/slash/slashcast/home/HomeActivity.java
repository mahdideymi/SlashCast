package com.slash.slashcast.home;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.slash.slashcast.R;
import com.slash.slashcast.databinding.ActivityHomeBinding;
import com.slash.slashcast.home.rvChapter.RvChapterAdapter;
import com.slash.slashcast.home.rvChapter.RvChapterDetail;
import com.slash.slashcast.home.rvChapter.RvChapterViewModel;
import com.slash.slashcast.home.rvHeader.RvHeaderAdapter;
import com.slash.slashcast.home.rvHeader.RvHeaderModel;
import com.slash.slashcast.home.rvHeader.RvHeaderViewModel;
import com.slash.slashcast.home.rvSubject.RvSubjectAdapter;
import com.slash.slashcast.home.rvSubject.RvSubjectModel;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    RecyclerView rvProduct;
    RecyclerView rvHeader;

    private RvChapterViewModel rvChapterViewModel;
    private RvHeaderViewModel rvHeaderViewModel;

    RvChapterAdapter rvChapterAdapter;
    RvHeaderAdapter rvHeaderAdapter;
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


        rvChapterViewModel = ViewModelProviders.of(this).get(RvChapterViewModel.class);

        rvProduct = binding.rvHomeProduct;
        rvChapterAdapter = new RvChapterAdapter();
        rvProduct.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rvProduct.setHasFixedSize(true);
        rvSubjectAdapter = new RvSubjectAdapter();
        rvProduct.setAdapter(rvSubjectAdapter);

        rvHeader = binding.rvHomeHeader;
        rvHeaderAdapter = new RvHeaderAdapter();
        rvHeaderViewModel = ViewModelProviders.of(this).get(RvHeaderViewModel.class);
        rvHeader.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        rvHeader.setHasFixedSize(true);
        rvHeader.setAdapter(rvHeaderAdapter);

        getAllHeaders();
        getAllChapters();



    }

    private void getAllHeaders() {
        rvHeaderViewModel.getAllHeaders().observe(this , rvHeaderModels -> {
            rvHeaderAdapter.setList((ArrayList<RvHeaderModel>) rvHeaderModels);
        });
    }

    private void getAllChapters() {
        rvChapterViewModel.getAllChapter().observe(this, rvChapterDetails -> {
            rvChapterAdapter.setChapterList((ArrayList<RvChapterDetail>) rvChapterDetails);
            ArrayList<RvSubjectModel> subjectList = new ArrayList<>();
            String[] title = new String[] {
                    "Newest","Free","Popular","Most visited"
            };
            for (int i = 0; i < 4; i++) {
                RvSubjectModel model = new RvSubjectModel();
                model.setChapterList((ArrayList<RvChapterDetail>) rvChapterDetails);
                model.setTitle(title[i]);
                subjectList.add(model);
            }
            rvSubjectAdapter.setList(subjectList);
        });
    }
}