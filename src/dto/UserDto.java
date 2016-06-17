package com.mySNS.dto;

import java.sql.Date;
import java.io.InputStream;

public class UserDto {
    private int user_id;
    private String user_name;
    private String email;
    private String password;
    private String icon_url;
    private InputStream icon;
    private Date create_date;
    private int existence_type;
    private int follow_count;
    private int follower_count;

    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getIcon_url() {
        return icon_url;
    }
    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }
    public Date getCreate_date() {
        return create_date;
    }
    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
    public int getExistence_type() {
        return existence_type;
    }
    public void setExistence_type(int existence_type) {
        this.existence_type = existence_type;
    }
    public int getFollow_count() {
        return follow_count;
    }
    public void setFollow_count(int follow_count) {
        this.follow_count = follow_count;
    }
    public int getFollower_count() {
        return follower_count;
    }
    public void setFollower_count(int follower_count) {
        this.follower_count = follower_count;
    }
}
