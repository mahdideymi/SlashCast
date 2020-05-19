package com.slash.slashcast.home.rvChapter;

import androidx.lifecycle.MutableLiveData;

import com.slash.slashcast.WebService.RetroGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RvChapterRepo {

    private ArrayList<RvChapterDetail> chapterList = new ArrayList<>();
    private MutableLiveData<List<RvChapterDetail>> mutableLiveData = new MutableLiveData<>();

    public RvChapterRepo() {

    }

    public MutableLiveData<List<RvChapterDetail>> getMutableLiveData() {

        final RvChapterService rvChapterService = RetroGenerator.getRetrofit("https://reqres.in").create(RvChapterService.class);
        Call<RvChapterModel> call = rvChapterService.getChapter();
        call.enqueue(new Callback<RvChapterModel>() {
            @Override
            public void onResponse(Call<RvChapterModel> call, Response<RvChapterModel> response) {
                if (response.isSuccessful()) {
                    RvChapterModel model = response.body();
                    chapterList = (ArrayList<RvChapterDetail>) model.getData();
                    mutableLiveData.setValue(chapterList);
                }
            }

            @Override
            public void onFailure(Call<RvChapterModel> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}