package com.mySNS.dto;

import java.sql.Date;

public class FavoriteDto {
    private int favorite_id;
    private int post_id;
    private int user_id;
    private Date favorite_date;
    public int getFavorite_id() {
        return favorite_id;
    }
    public void setFavorite_id(int favorite_id) {
        this.favorite_id = favorite_id;
    }
    public int getPost_id() {
        return post_id;
    }
    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public Date getFavorite_date() {
        return favorite_date;
    }
    public void setFavorite_date(Date favorite_date) {
        this.favorite_date = favorite_date;
    }

}
