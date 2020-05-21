package com.slash.slashcast.home.rvChapter;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class RvChapterViewModel extends AndroidViewModel {
    private RvChapterRepo repo;
    public RvChapterViewModel(@NonNull Application application) {
        super(application);
        repo = new RvChapterRepo();
    }

    public LiveData<List<RvChapterDetail>> getAllChapter () {
        return repo.getMutableLiveData();
    }
}
