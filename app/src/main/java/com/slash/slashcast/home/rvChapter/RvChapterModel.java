package com.slash.slashcast.home.rvChapter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RvChapterModel {
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("per_page")
    @Expose
    private Integer perPage;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("data")
    @Expose
    private List<RvChapterDetail> data = null;
    @SerializedName("ad")
    @Expose
    private RvChapterAd ad;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<RvChapterDetail> getData() {
        return data;
    }

    public void setData(List<RvChapterDetail> data) {
        this.data = data;
    }

    public RvChapterAd getAd() {
        return ad;
    }

    public void setAd(RvChapterAd ad) {
        this.ad = ad;
    }

}
