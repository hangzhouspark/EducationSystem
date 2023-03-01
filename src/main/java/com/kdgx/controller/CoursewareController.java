package com.kdgx.controller;

import com.kdgx.entity.Courseware;
import com.kdgx.entity.Loginusers;
import com.kdgx.service.CoursewareService;
import com.kdgx.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@SuppressWarnings("all")
public class CoursewareController {

    @Autowired
    private CoursewareService coursewareService;

//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");

    /**
     * 获取课件的信息数据
     *
     * @param request
     * @return
     */
    @GetMapping("selectCourseware")
    @ResponseBody
    public R selectCourseware() {
        List<Courseware> coursewares = coursewareService.selectCourseware();
        return R.ok().data("coursewares", coursewares);
    }

    private String fileSavePath;

    @PostMapping("/upload")
    public String upload(int cid, MultipartFile uploadFile, HttpServletRequest req) throws IOException {
        String realPath = "E:/ideaproject/EducationSystem/src/main/resources/static/file";
        String filePath = "";
        String oldName = uploadFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
        uploadFile.transferTo(new File(realPath + "/" + newName));
        filePath = "http://localhost:8001/file/" + newName;
        Courseware entity = new Courseware();
        entity.setCid(cid);
        entity.setCware(newName);
        int i = coursewareService.updateCoursewareByCware(entity);
        if (i > 0) {
            return "TeacherLogin";
        } else {
            return "TeacherLogin";
        }
    }
}
