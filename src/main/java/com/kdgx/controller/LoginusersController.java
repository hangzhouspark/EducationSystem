package com.kdgx.controller;

import com.kdgx.entity.Loginusers;
import com.kdgx.service.LoginusersService;
import com.kdgx.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @GetMapping("selectLoginUsers")
    @ResponseBody
    public R selectLoginUsers() {
        List<Loginusers> selectLoginUsers = loginusersService.selectLoginUsers();
        return R.ok().data("selectLoginUsers", selectLoginUsers);
    }

    @RequestMapping("goinsertlogin")
    public String goinsertlogin() {
        return "insertloginPage";
    }

    @RequestMapping("insertlogin")
    public R insertlogin(@RequestBody Loginusers entity,HttpServletRequest request) {
//      String lusername = request.getParameter("lusername");
//      String lpassword = request.getParameter("lpassword");
//      int lisadmin = Integer.parseInt(request.getParameter("lisadmin"));
        int i = loginusersService.insertlogin(entity);
        if (i > 0) {
            return R.ok().data("i",i);
        }
        return R.error().message("添加失败");
    }

}
