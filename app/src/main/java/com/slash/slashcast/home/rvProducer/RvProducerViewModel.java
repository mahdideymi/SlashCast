package com.slash.slashcast.home.rvProducer;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class RvProducerViewModel extends AndroidViewModel {

    private RvProducerRepo repo;
    public RvProducerViewModel(@NonNull Application application) {
        super(application);
        repo = new RvProducerRepo();
    }

    public LiveData<List<RvProducerModel>> getProducers() {
        return repo.getMutableLiveData();
    }
}
