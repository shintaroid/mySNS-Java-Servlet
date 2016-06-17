package com.mySNS.dto;

import java.sql.Date;

public class PostDto {
    private int post_id;
    private String post_data;
    private int user_id;
    private Date post_date;
    private int img_count;
    private int favorite_count;
    private int comment_count;
    private int posted_target;
    private int top_posted_target;
    public int getPost_id() {
        return post_id;
    }
    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }
    public String getPost_data() {
        return post_data;
    }
    public void setPost_data(String post_data) {
        this.post_data = post_data;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public Date getPost_date() {
        return post_date;
    }
    public void setPost_date(Date post_date) {
        this.post_date = post_date;
    }
    public int getImg_count() {
        return img_count;
    }
    public void setImg_count(int img_count) {
        this.img_count = img_count;
    }
    public int getFavorite_count() {
        return favorite_count;
    }
    public void setFavorite_count(int like_count) {
        this.favorite_count = like_count;
    }
    public int getComment_count() {
        return comment_count;
    }
    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }
    public int getPosted_target() {
        return posted_target;
    }
    public void setPosted_target(int posted_target) {
        this.posted_target = posted_target;
    }
    public int getTop_posted_target() {
        return top_posted_target;
    }
    public void setTop_posted_target(int top_posted_target) {
        this.top_posted_target = top_posted_target;
    }

}
