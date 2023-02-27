package com.kdgx.controller;

import com.kdgx.entity.Student;
import com.kdgx.entity.Teacher;
import com.kdgx.service.TeacherService;
import com.kdgx.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@SuppressWarnings("all")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 获取老师的信息
     *
     * @param request
     * @return
     */
    @GetMapping("TeacherAllMag")
    @ResponseBody
    public R TeacherAllMag(HttpServletRequest request) {
        List<Teacher> teachersMag = teacherService.selectTeacher();
        return R.ok().data("teachersMag", teachersMag);
    }

    /**
     * 添加老师信息
     *
     * @param entity
     * @param
     * @return
     */
    @RequestMapping("insertTeacher")
    @ResponseBody
    public R insertTeacher(Teacher entity) {
        int i = teacherService.insertTeacher(entity);
        if (i > 0) {
            return R.ok().message("添加成功");
        }
        return R.error().message("添加失败");
    }

    /**
     * 删除老师信息
     *
     * @param entity
     * @return
     */
    @RequestMapping("deleteTeacher")
    @ResponseBody
    public R deleteTeacher(Teacher entity) {
        int i = teacherService.deleteTeacher(entity);
        if (i > 0) {
            return R.ok().message("删除成功");
        }
        return R.error().message("删除失败");
    }

    /**
     * 回显单个老师信息
     *
     * @param entity
     * @return
     */
    @GetMapping("selectTeacherBytid")
    @ResponseBody
    public R selectTeacherBytid(Teacher entity) {
        Teacher selectTeacherBytid = teacherService.selectTeacherByTid(entity);
        return R.ok().data("selectTeacherBytid", selectTeacherBytid);
    }

    /**
     * 修改老师账户信息
     *
     * @param entity
     * @return
     */
    @RequestMapping("updateTeacher")
    @ResponseBody
    public R updateTeacher(Teacher entity) {
        int i = teacherService.updateTeacher(entity);
        if (i > 0) {
            return R.ok().message("修改成功");
        } else {
            return R.error().message("修改失败");
        }
    }
}
