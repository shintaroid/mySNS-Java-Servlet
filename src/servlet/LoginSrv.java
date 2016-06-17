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
import com.mySNS.service.UserManageService;

@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginSrv extends SuperSrv {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginSrv() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//HttpSession session = getSession(request);
		/*String message = getMessage(request);
		try {
			switch (message) {
				case "login":
					UserDto dto = new UserDto();
					dto.setEmail(request.getParameter("mail"));
					dto.setPassword(request.getParameter("pass"));
					LoginService.login(dto, request);
					//request.getRequestDispatcher("post.jsp").forward(request, response);
				case "logout":
					LoginService.logout(request);
					request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (SNSException e) {
			doErrorAction(request, response, e);
		}*/
		UserDto user = null;
		user = UserManageService.loginAuth(request.getParameter("email"), request.getParameter("pass"));
		if(user == null){
			out.println("It is null");
		}else{out.println("Ok");}

	}

}
