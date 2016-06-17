package com.mySNS.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import com.mySNS.dto.UserDto;

public class SuperUserDao{

  private Connection conn;

  public SuperUserDao(){
  }

  //create a table called "User"
  public void createTableUser(){
    try{
      String sql = "CREATE TABLE IF NOT EXISTS user("+
          "user_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT"+
          ",user_name VARCHAR(32)"+
          ",email VARCHAR(254)"+
          ",password VARCHAR(128)"+
          ",icon_img BLOB"+
          ",create_date TIMESTAMP"+
          ",existence_type INT NOT NULL DEFAULT 0"+
          ",follow_count INT NOT NULL DEFAULT 0"+
          ",follower_count INT NOT NULL DEFAULT 0)";
      Statement stmt = conn.createStatement();
      stmt.executeUpdate(sql);
    }catch(SQLException e){e.printStackTrace();}
  }

  //create a table called 'post'
  public void createTablePost(){
    try{
      String sql = "CREATE TABLE IF NOT EXISTS post("+
          "post_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT"+
          ",post_data TEXT NOT NULL"+
          ",user_id INT NOT NULL"+
          ",post_date TIMESTAMP"+
          ",img_count INT DEFAULT 0"+
          ",like_count INT DEFAULT 0"+
          ",comment_count INT DEFAULT 0"+
          ",posted_target INT DEFAULT NULL"+
          ",top_posted_target INT DEFAULT NULL)";
      Statement stmt = conn.createStatement();
      stmt.executeUpdate(sql);
    }catch(SQLException e){e.printStackTrace();}
  }

  //create a table called 'favorite'
  public void createTableFavorite(){
    try{
      String sql = "CREATE TABLE IF NOT EXISTS favorite("+
          "favorite_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT"+
          ",post_id INT NOT NULL"+
          ",user_id INT NOT NULL"+
          ",favorite_date TIMESTAMP)";
      Statement stmt = conn.createStatement();
      stmt.executeUpdate(sql);
    }catch(SQLException e){e.printStackTrace();}
  }

  //create a table called img
  public void createTableImg(){
    try{
      String sql = "CREATE TABLE IF NOT EXISTS img("+
          "img_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT"+
          ",post_id INT NOT NULL"+
          ",url VARCHAR(255))";
      Statement stmt = conn.createStatement();
      stmt.executeUpdate(sql);
    }catch(SQLException e){e.printStackTrace();}
  }

  //create a table called 'follow'
  public void createTableFollow(){
    try{
      String sql = "CREATE TABLE IF NOT EXISTS follow("+
          "follow_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT"+
          ",user_id INT"+
          ",follow_user_id INT"+
          ",follow_date TIMESTAMP)";
      Statement stmt = conn.createStatement();
      stmt.executeUpdate(sql);
    }catch(SQLException e){e.printStackTrace();}
  }

  //delete a table
  public void deleteTable(String table){
    try{
      String sql = "DROP TABLE IF EXISTS " +table+ ";";
      Statement stmt = conn.createStatement();
      stmt.executeUpdate(sql);
    }catch(SQLException e){e.printStackTrace();}
  }

  // get all users' information
  public List<UserDto> getAllUsers() {
    List<UserDto> users = new ArrayList<UserDto>();
    try {
      Statement statement = conn.createStatement();
      ResultSet rs = statement.executeQuery("select * from users");
      while (rs.next()) {
        UserDto user = new UserDto();
        user.setUser_id(rs.getInt("user_id"));
        user.setUser_name(rs.getString("user_name"));
        user.setEmail(rs.getString("email"));
        users.add(user);
      }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return users;
  }
}
