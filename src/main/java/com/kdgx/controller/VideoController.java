package com.kdgx.controller;

import com.kdgx.entity.Video;
import com.kdgx.service.VideoService;
import com.kdgx.util.R;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

@Controller
@SuppressWarnings("all")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 获取课件的信息数据
     *
     * @param request
     * @return
     */
    @GetMapping("selectVideo")
    @ResponseBody
    public R selectVideo() {
        List<Video> Videos = videoService.selectVideo();
        return R.ok().data("Videos", Videos);
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
    @PostMapping("/uploadV")
    public String uploadV(int vid, MultipartFile uploadFile, HttpServletRequest req) throws IOException {
        System.out.println("uploadFile" + uploadFile);
        String realPath = "E:/ideaproject/EducationSystem/src/main/resources/static/video";
        String filePath = "";
        String oldName = uploadFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
        uploadFile.transferTo(new File(realPath + "/" + newName));
        filePath = "http://localhost:8001/video/" + newName;
        Video entity = new Video();
        entity.setVid(vid);
        entity.setVware(newName);
        int i = videoService.updateVideoByvware(entity);
        if (i > 0) {
            return "TeacherLogin";
        } else {
            return "TeacherLogin";
        }
    }

    /**
     * 下载视频
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("downloadVideo")
    public String downloadVideo(String fileName, HttpServletResponse response) throws IOException {
        // 获取项目根路径
        String realPath = System.getProperty("user.dir") + "/src/main/resources/static/video";
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
        return "StudentLogin";
    }

    /**
     * 删除课件信息
     *
     * @param entity
     * @return
     */
    @RequestMapping("deleteVideo")
    @ResponseBody
    public R deleteVideo(Video entity) {
        int i = videoService.deleteVideo(entity);
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
    @RequestMapping("insertVideo")
    @ResponseBody
    public R insertVideo(Video entity) {
        int i = videoService.insertVideo(entity);
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
    @GetMapping("selectVideoByvid")
    @ResponseBody
    public R selectVideoByvid(Video entity) {
        Video selectVideoByvid = videoService.selectVideoByvid(entity);
        return R.ok().data("selectVideoByvid", selectVideoByvid);
    }

    /**
     * 修改课件信息
     *
     * @param entity
     * @return
     */
    @RequestMapping("updateVideo")
    @ResponseBody
    public R updateVideo(Video entity) {
        int i = videoService.updateVideo(entity);
        if (i > 0) {
            return R.ok().message("修改成功");
        } else {
            return R.error().message("修改失败");
        }
    }

}
