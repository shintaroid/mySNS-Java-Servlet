package com.mySNS.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mySNS.dto.UserDto;
import com.mySNS.facade.SuperFacade;

public class SuperUserService{

  public static void createTable(String table){
    SuperFacade.createTable(table);
  }

  public static void deleteTable(String table){
    SuperFacade.deleteTable(table);
  }


}
