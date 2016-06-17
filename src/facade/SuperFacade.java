package com.mySNS.facade;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.mySNS.dao.*;
import com.mySNS.dto.*;

public class SuperFacade{

  private static SuperUserDao superUserDao;

  SuperFacade(){
  }

  // create a table
  public static void createTable(String table){
    superUserDao = new SuperUserDao();
    switch(table){
      case "user":
        superUserDao.createTableUser();
        break;
      case "post":
        superUserDao.createTablePost();
      case "favorite":
        superUserDao.createTableFavorite();
        break;
      case "follow":
        superUserDao.createTableFollow();
        break;
      case "img":
        superUserDao.createTableImg();
      default:
        break;
    }
  }

  //delete a table
  public static void deleteTable(String table){
    superUserDao = new SuperUserDao();
    switch(table){
      case "user":
        superUserDao.deleteTable(table);
        break;
      case "post":
        superUserDao.deleteTable(table);
        break;
      case "favorite":
        superUserDao.deleteTable(table);
        break;
      case "follow":
        superUserDao.deleteTable(table);
        break;
      case "img":
        superUserDao.deleteTable(table);
        break;
      default:
        break;
    }
  }
}
