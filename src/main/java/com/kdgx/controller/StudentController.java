package com.kdgx.controller;

import com.kdgx.entity.Loginusers;
import com.kdgx.entity.Student;
import com.kdgx.service.StudentService;
import com.kdgx.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@SuppressWarnings("all")
public class StudentController {
    @Autowired
    private StudentService studentService;


    /**
     * 获取学生的信息
     *
     * @param request
     * @return
     */
    @GetMapping("StudentAllMag")
    @ResponseBody
    public R StudentAllMag(HttpServletRequest request) {
        List<Student> studentsMag = studentService.selectStudent();
//        SimpleDateFormat date_format1 = new SimpleDateFormat("MM/dd/yyyy");
//            String format = date_format1.format(entity.getSbirthday());
        return R.ok().data("studentsMag", studentsMag);
    }


    /**
     * 添加学生信息
     *
     * @param entity
     * @param
     * @return
     */
    @RequestMapping("insertStudent")
    @ResponseBody
    public R insertStudent(Student entity) {
        int i = studentService.insertStudent(entity);
        if (i > 0) {
            return R.ok().message("添加成功");
        }
        return R.error().message("添加失败");
    }

    /**
     * 删除学生信息
     *
     * @param entity
     * @return
     */
    @RequestMapping("deleteStudent")
    @ResponseBody
    public R deleteStudent(Student entity) {
        int i = studentService.deleteStudent(entity);
        if (i > 0) {
            return R.ok().message("删除成功");
        }
        return R.error().message("删除失败");
    }


    /**
     * 回显单个学生信息
     *
     * @param entity
     * @return
     */
    @GetMapping("selectStudentBysid")
    @ResponseBody
    public R selectStudentBysid(Student entity) {
        Student selectStudentBysid = studentService.selectStudentBySid(entity);
        return R.ok().data("selectStudentBysid", selectStudentBysid);
    }

    /**
     * 修改学生账户信息
     *
     * @param entity
     * @return
     */
    @RequestMapping("updateStudent")
    @ResponseBody
    public R updateStudent(Student entity) {
        int i = studentService.updateStudent(entity);
        if (i > 0) {
            return R.ok().message("修改成功");
        } else {
            return R.error().message("修改失败");
        }
    }
}
