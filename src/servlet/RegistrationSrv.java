package com.mySNS.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mySNS.dto.UserDto;
import com.mySNS.service.UserManageService;

@WebServlet(name = "registration", urlPatterns = { "/registration" })
@MultipartConfig(maxFileSize = 50000)
public class RegistrationSrv  extends SuperSrv{

	private static final long serialVersionUID = 1L;
	private UserDto dto;

  public RegistrationSrv() {
    super();
        // TODO Auto-generated constructor stub
  }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		//setUrl("C:/test/icon/");
  	dto = new UserDto();
  	/*HashMap<String,String> map = new HashMap<>();
  	try {
			map= uploadImage(request,UserDao.incrementShow(DbUtil.getConnection()));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    String mail = map.get("mail");
    if(mail == null){
    	mail = request.getParameter("mail");
    }
    String pass = map.get("pass");
    if(pass == null){
    	pass = request.getParameter("pass");
    }
    String url = map.get("url1");
    if(url == null){
    	url = request.getParameter("url1");
    }
    String name = map.get("name");
    if(name == null){
    	name = request.getParameter("name");
    }
    String confpass = map.get("confpass");
    if(confpass == null){
    	confpass = request.getParameter("confpass");
    }*/
  	dto.setEmail(request.getParameter("email"));
  	dto.setPassword(request.getParameter("pass"));
  	dto.setUser_name(request.getParameter("name"));
		InputStream input = null;
		Part file = request.getPart("icon");
		input = file.getInputStream();

  	UserManageService.addUser(dto, request, input);
  	//HttpSession session = getSession(request);

  	//request.getRequestDispatcher("post.jsp").forward(request, response);

	}

}
