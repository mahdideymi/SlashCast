package com.slash.slashcast.profile.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.slash.slashcast.Application;
import com.slash.slashcast.R;
import com.slash.slashcast.profile.rvProfile.RvProfileAdapter;
import com.slash.slashcast.profile.rvProfile.RvProfileModel;

import java.util.ArrayList;
import java.util.List;

public class DownloadFragment extends Fragment {


    private RecyclerView recyclerView;
    private RvProfileAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_download, container, false);

        init(view);

        recyclerView.setLayoutManager(new LinearLayoutManager(Application.getContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void init(View view) {
        recyclerView = view.findViewById(R.id.rvProfile);
        adapter = new RvProfileAdapter(getList());
    }

    public List<RvProfileModel> getList() {
        List<RvProfileModel> list = new ArrayList<>();
        RvProfileModel model = new RvProfileModel("https://source.unsplash.com/100x100/?sweet",
                "How to cook sweet?", "https://source.unsplash.com/100x100/?avatar",
                "Samira", "3:09", " $ 15", false);
        list.add(model);

        RvProfileModel model1 = new RvProfileModel("https://source.unsplash.com/100x100/?me",
                "Design brief", "https://source.unsplash.com/100x100/?ronaldo",
                "Sara Mirzaeian", "14:34", " $ 5", true);
        list.add(model1);

        RvProfileModel model2 = new RvProfileModel("https://source.unsplash.com/100x100/?font",
                "10 Tip in font", "https://source.unsplash.com/100x100/?iran",
                "Mohammad Teymouri", "07:14", " $ 7", false);
        list.add(model2);

        return list;

    }
}
