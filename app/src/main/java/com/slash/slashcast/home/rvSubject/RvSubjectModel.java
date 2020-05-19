package com.slash.slashcast.home.rvSubject;

import com.slash.slashcast.home.rvChapter.RvChapterModel;

import java.util.ArrayList;

public class RvSubjectModel {
    private String Title;
    private ArrayList<RvChapterModel> chapterList;
    private int id;

    public RvSubjectModel(String title, ArrayList<RvChapterModel> chapterList, int id) {
        Title = title;
        this.chapterList = chapterList;
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public ArrayList<RvChapterModel> getChapterList() {
        return chapterList;
    }

    public void setChapterList(ArrayList<RvChapterModel> chapterList) {
        this.chapterList = chapterList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
