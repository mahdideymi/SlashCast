package com.slash.slashcast.profile.rvProfile;

public class RvProfileModel {
    private String pic;
    private String title;
    private String authorPic;
    private String authorName;
    private String time;
    private String price;
    private boolean Bookmark;

    public RvProfileModel(String pic, String title, String authorPic, String authorName,
                          String time, String price, boolean bookmark) {
        this.pic = pic;
        this.title = title;
        this.authorPic = authorPic;
        this.authorName = authorName;
        this.time = time;
        this.price = price;
        Bookmark = bookmark;
    }


    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorPic() {
        return authorPic;
    }

    public void setAuthorPic(String authorPic) {
        this.authorPic = authorPic;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isBookmark() {
        return Bookmark;
    }

    public void setBookmark(boolean bookmark) {
        Bookmark = bookmark;
    }
}
