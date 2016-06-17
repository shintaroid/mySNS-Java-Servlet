package com.mySNS.service;

import java.util.ArrayList;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mySNS.dto.UserDto;
import com.mySNS.facade.Facade;

public class UserManageService {

    /*public static UserDto getUserInfo(int userid) throws SNSException {
        UserDto user = new UserDto();
        user = Facade.profileSelect(userid);
        return user;
    }*/

    /*public static boolean editUserInfo(UserDto u, ArrayList<String> password) throws SNSException {
        if(u.getIcon_url() != null){
            Facade.profileImgEdit(u);
        }
        ValidationHandling.emailValidation(u.getEmail());
        ValidationHandling.userValidation(u.getUser_name());
        Facade.profileEdit(u);
        if(password != null){
            ValidationHandling.passValidation(password.get(0));
            ValidationHandling.passValidation(password.get(1));
            if(password.get(0).equals(password.get(1))){
                boolean f = Facade.passCheck(u);
                if(f){
                    UserDto pass = new UserDto();
                    pass.setUser_id(u.getUser_id());
                    pass.setPassword(password.get(0));
                    Facade.passEdit(pass);
                }else{
                    throw new SNSException(ERROR_CODE.PASSWORD_ERROR);
                }
            }else{
                throw new SNSException(ERROR_CODE.PASSWORD_ERROR);
            }
        }
        return true;
    }*/

    /*public static boolean deleteUser(int user_id) throws SNSException {
        boolean t = Facade.userDelete(user_id);
        return t;
    }*/

    public static void addUser(UserDto dto, HttpServletRequest request, InputStream input) {

        Facade.addUser(dto, input);


        /*if(dto.getIcon_url() != null){
            String fileName = dto.getIcon_url();
            int lastDotPosition = fileName.lastIndexOf(".");
            if (lastDotPosition != -1) {
                String a = "C:/test/img/" + dto2.getUser_id() + "." + fileName.substring(lastDotPosition + 1);
                dto.setIcon_url(a);
            }
            Facade.profileImgEdit(dto);
        }*/
        //HttpSession session = request.getSession(true);
        //session.setAttribute("userid",String.valueOf(dto2.getUser_id()));
        //session.setAttribute("username",dto2.getUser_name());
    }

    public static UserDto loginAuth(String email, String password){
      UserDto user = null;
      user = Facade.loginAuth(email, password);
      return user;
    }
}
