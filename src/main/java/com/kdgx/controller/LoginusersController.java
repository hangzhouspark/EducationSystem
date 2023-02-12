package com.kdgx.controller;

import com.kdgx.entity.Loginusers;
import com.kdgx.service.LoginusersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@SuppressWarnings("all")
public class LoginusersController {
    @Autowired
    private LoginusersService loginusersService;

    @RequestMapping("/")
    public String index() {
        return "LoginPage";
    }

    /**
     * 登陆
     *
     * @param entity
     * @param request
     * @return
     */
    @RequestMapping("loginAllUser")
    public String loginAllUser(HttpServletRequest request) {
        String lusername = request.getParameter("lusername");
        String lpassword = request.getParameter("lpassword");
        int lisadmin = Integer.parseInt(request.getParameter("lisadmin"));
        Loginusers entity = new Loginusers();
        entity.setLusername(lusername);
        entity.setLpassword(lpassword);
        entity.setLisadmin(lisadmin);
        Loginusers loginMess = loginusersService.loginAllUser(entity);
        //System.out.println(loginMess);
        if (loginMess != null) {
            if (loginMess.getLisadmin() == 0) {
                return "StudentLogin";
            } else if (loginMess.getLisadmin() == 1) {
                request.getSession().setAttribute("loginMess", loginMess);
                return "TeacherLogin";
            } else {
                return "AdminLogin";
            }
        } else {
            return "LoginPage";
        }
    }

}
