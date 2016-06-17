package com.mySNS.dto;

public class ImgDto {
    private int img_id;
    private int post_id;
    private String[] url;
    public int getImg_id() {
        return img_id;
    }
    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }
    public int getPost_id() {
        return post_id;
    }
    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }
    public String[] getUrl() {
        return url;
    }
    public void setUrl(String[] url) {
        this.url = url;
    }

}
