package com.mySNS.dto;

import java.sql.Date;

public class FollowDto {
    private int follow_id;
    private int user_id;
    private int follow_user_id;
    private Date follow_date;
    public int getFollow_id() {
        return follow_id;
    }
    public void setFollow_id(int follow_id) {
        this.follow_id = follow_id;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public int getFollow_user_id() {
        return follow_user_id;
    }
    public void setFollow_user_id(int follow_user_id) {
        this.follow_user_id = follow_user_id;
    }
    public Date getFollow_date() {
        return follow_date;
    }
    public void setFollow_date(Date follow_date) {
        this.follow_date = follow_date;
    }

}
