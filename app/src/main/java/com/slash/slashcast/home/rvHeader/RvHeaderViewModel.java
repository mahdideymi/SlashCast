package com.slash.slashcast.home.rvHeader;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class RvHeaderViewModel extends AndroidViewModel {

    private RvHeaderRepo rvHeaderRepo;
    public RvHeaderViewModel(@NonNull Application application) {
        super(application);
        rvHeaderRepo = new RvHeaderRepo();
    }

    public LiveData<List<RvHeaderModel>> getAllHeaders() {
        return rvHeaderRepo.getMutableLiveData();
    }
}
