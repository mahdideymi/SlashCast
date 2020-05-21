package com.slash.slashcast.home.rvSubject;

import com.slash.slashcast.home.rvChapter.RvChapterDetail;
import com.slash.slashcast.home.rvHeader.RvHeaderModel;

import java.util.ArrayList;

public class RvSubjectModel {
    private String Title;
    private ArrayList<RvChapterDetail> chapterList;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public ArrayList<RvChapterDetail> getChapterList() {
        return chapterList;
    }

    public void setChapterList(ArrayList<RvChapterDetail> chapterList) {
        this.chapterList = chapterList;
    }
}
