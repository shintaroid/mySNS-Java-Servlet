package com.mySNS.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mySNS.dto.UserDto;
import com.mySNS.service.SuperUserService;

@WebServlet(name = "SuperUser", urlPatterns = { "/superuser" })
public class SuperUserSrv extends SuperSrv{

	private UserDto dto;

  public SuperUserSrv() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                            throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    if(request.getParameter("create_table") != null){
      SuperUserService.createTable(request.getParameter("create_table"));
    }

    if(request.getParameter("delete_table") != null){
      SuperUserService.deleteTable(request.getParameter("delete_table"));
    }
  }
}
