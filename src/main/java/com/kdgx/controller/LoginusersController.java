package com.kdgx.controller;

import com.kdgx.entity.Loginusers;
import com.kdgx.service.LoginusersService;
import com.kdgx.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SuppressWarnings("all")
public class LoginusersController {
    @Autowired
    private LoginusersService loginusersService;

    /**
     * 设置起始页
     *
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "LoginPage";
    }

    /**
     * 登陆账户
     *
     * @param users
     * @param request
     * @return
     */
    @RequestMapping("loginAllUser")
    @ResponseBody
    public R loginAllUser(Loginusers users, HttpServletRequest request) {
        Loginusers logilog = loginusersService.loginAllUser(users);
        if (logilog != null) {
            request.getSession().setAttribute("logilog", logilog);
            return R.ok().data("logilog", logilog);
        } else {
            return R.error().message("登录失败");
        }
    }

    /**
     * 获取登录的信息
     *
     * @param request
     * @return
     */
    @GetMapping("LoginMag")
    @ResponseBody
    public R LoginMag(HttpServletRequest request) {
        Loginusers LoginMag = (Loginusers) request.getSession().getAttribute("logilog");
        return R.ok().data("LoginMag", LoginMag);
    }

    /**
     * 跳转管理员登录页
     *
     * @return
     */
    @RequestMapping("AdminLogin")
    public String AdminLogin() {
        return "AdminLogin";
    }

    /**
     * 跳转老师登录页
     *
     * @return
     */
    @RequestMapping("TeacherLogin")
    public String TeacherLogin() {
        return "TeacherLogin";
    }

    /**
     * 跳转学生登录页
     *
     * @return
     */
    @RequestMapping("StudentLogin")
    public String StudentLogin() {
        return "StudentLogin";
    }


    /**
     * 查看登录账号信息
     *
     * @return
     */
    @GetMapping("selectLoginUsers")
    @ResponseBody
    public R selectLoginUsers() {
        List<Loginusers> selectLoginUsers = loginusersService.selectLoginUsers();
        return R.ok().data("selectLoginUsers", selectLoginUsers);
    }

    /**
     * 添加登陆账户
     *
     * @param entity
     * @param
     * @return
     */
    @RequestMapping("insertlogin")
    @ResponseBody
    public R insertlogin(Loginusers entity) {
        int i = loginusersService.insertlogin(entity);
        if (i > 0) {
            return R.ok().message("添加成功");
        }
        return R.error().message("添加失败");
    }

    /**
     * 删除登陆账户信息
     *
     * @param entity
     * @return
     */
    @RequestMapping("deleteLogin")
    @ResponseBody
    public R deleteLogin(Loginusers entity) {
        int i = loginusersService.deleteLogin(entity);
        if (i > 0) {
            return R.ok().message("删除成功");
        }
        return R.error().message("删除失败");
    }

    /**
     * 回显单个登录信息
     *
     * @param entity
     * @return
     */
    @GetMapping("selectLoginUsersBylid")
    @ResponseBody
    public R selectLoginUsersBylid(Loginusers entity) {
        Loginusers loginusersBylid = loginusersService.selectLoginUsersBylid(entity);
        return R.ok().data("loginusersBylid", loginusersBylid);
    }

    /**
     * 修改登陆账户信息
     *
     * @param entity
     * @return
     */
    @RequestMapping("updateLogin")
    @ResponseBody
    public R updateLogin(Loginusers entity) {
        int i = loginusersService.updateLogin(entity);
        if (i > 0) {
            return R.ok().message("修改成功");
        }
        return R.error().message("修改失败");
    }

    /**
     * 修改登陆账户信息
     *
     * @param entity
     * @return
     */
    @RequestMapping("updateLoginByPassword")
    @ResponseBody
    public R updateLoginByPassword(Loginusers entity) {
        int i = loginusersService.updateLoginByPassword(entity);
        if (i > 0) {
            return R.ok().message("修改密码成功");
        }
        return R.error().message("修改密码失败");
    }

    // 退出登录
    @PostMapping("loginOut")
    @ResponseBody
    public R loginOut(HttpServletRequest request) {
        request.getSession().removeAttribute("logilog");
        return R.ok().message("退出成功");
    }


}
