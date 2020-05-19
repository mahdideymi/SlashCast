package com.slash.slashcast.home.rvChapter;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RvChapterService {

    @GET("/api/unknown")
    Call<RvChapterModel> getChapter();
}
