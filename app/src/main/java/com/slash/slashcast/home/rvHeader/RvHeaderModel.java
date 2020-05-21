package com.slash.slashcast.home.rvHeader;

public class RvHeaderModel {
    private String pic;
    private String title;
    private String profileName;
    private String profilePic;
    private String price;

    RvHeaderModel(String pic, String title, String profileName, String profilePic, String price) {
        this.pic = pic;
        this.title = title;
        this.profileName = profileName;
        this.profilePic = profilePic;
        this.price = price;
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

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
