package com.kdgx.controller;

import com.kdgx.entity.Courseware;
import com.kdgx.service.CoursewareService;
import com.kdgx.util.R;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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

    /**
     * 上传课件
     *
     * @param cid
     * @param uploadFile
     * @param req
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public String upload(int cid, MultipartFile uploadFile, HttpServletRequest req) throws IOException {
        System.out.println("uploadFile" + uploadFile);
        String realPath = System.getProperty("user.dir") + "/src/main/resources/static/file";
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

    /**
     * 下载课件
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("downloadFile")
    public void download(String fileName, HttpServletResponse response) throws IOException {
        // 获取项目根路径
        String realPath = System.getProperty("user.dir") + "/src/main/resources/static/file";
        // 获得文件输入流
        FileInputStream inputStream = new FileInputStream(new File(realPath, fileName));
        // 设置文件下载方式：附件下载
        response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
        // 获取响应输出流
        ServletOutputStream outputStream = response.getOutputStream();
        // 下载文件
        IOUtils.copy(inputStream, outputStream);
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(outputStream);
    }


    /**
     * 删除课件信息
     *
     * @param entity
     * @return
     */
    @RequestMapping("deleteCourseware")
    @ResponseBody
    public R deleteCourseware(Courseware entity) {
        int i = coursewareService.deleteCourseware(entity);
        if (i > 0) {
            return R.ok().message("删除成功");
        }
        return R.error().message("删除失败");
    }

    /**
     * 添加课件信息
     *
     * @param entity
     * @param
     * @return
     */
    @RequestMapping("insertCourseware")
    @ResponseBody
    public R insertCourseware(Courseware entity) {
        int i = coursewareService.insertCourseware(entity);
        if (i > 0) {
            return R.ok().message("添加成功");
        }
        return R.error().message("添加失败");
    }


    /**
     * 获取课件的回显的信息数据
     *
     * @param request
     * @return
     */
    @GetMapping("selectCoursewareBycid")
    @ResponseBody
    public R selectCoursewareBycid(Courseware entity) {
        Courseware selectCoursewareBycid = coursewareService.selectCoursewareByCid(entity);
        return R.ok().data("selectCoursewareBycid", selectCoursewareBycid);
    }

    /**
     * 修改课件信息
     *
     * @param entity
     * @return
     */
    @RequestMapping("updateCourseware")
    @ResponseBody
    public R updateCourseware(Courseware entity) {
        int i = coursewareService.updateCourseware(entity);
        if (i > 0) {
            return R.ok().message("修改成功");
        } else {
            return R.error().message("修改失败");
        }
    }


}
