package com.slash.slashcast.home.rvProducer;

public class RvProducerModel {
    private String img;
    private String name;

    public RvProducerModel(String img, String name) {
        this.img = img;
        this.name = name;
    }

    public RvProducerModel() {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
