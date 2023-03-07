package com.kdgx.controller;

import com.kdgx.entity.Courseware;
import com.kdgx.entity.Loginusers;
import com.kdgx.entity.Message;
import com.kdgx.entity.Student;
import com.kdgx.service.MessageService;
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
public class MessageController {
    @Autowired
    private MessageService messageService;

    /**
     * 查询问答信息
     *
     * @param request
     * @return
     */
    @GetMapping("selectMessage")
    @ResponseBody
    public R selectMessage() {
        List<Message> messages = messageService.selectMessage();
        return R.ok().data("messages", messages);
    }

    /**
     * 添加问答记录
     *
     * @param entity
     * @return
     */
    @RequestMapping("insertQuesByStudent")
    @ResponseBody
    public R insertQuesByStudent(Message entity) {
        int i = messageService.insertQuesByStudent(entity);
        if (i > 0) {
            return R.ok().message("添加成功");
        }
        return R.error().message("添加失败");
    }


    /**
     * 删除问答记录
     *
     * @param entity
     * @return
     */
    @RequestMapping("deleteMessage")
    @ResponseBody
    public R deleteMessage(Message entity) {
        int i = messageService.deleteMessage(entity);
        if (i > 0) {
            return R.ok().message("删除成功");
        }
        return R.error().message("删除失败");
    }

    /**
     * 回显答案
     *
     * @param entity
     * @return
     */
    @GetMapping("selectMessageBymid")
    @ResponseBody
    public R selectMessageBymid(Message entity) {
        Message selectMessageBymid = messageService.selectMessageBymid(entity);
        return R.ok().data("selectMessageBymid", selectMessageBymid);
    }

    /**
     * 回答答案
     *
     * @param entity
     * @return
     */
    @RequestMapping("updateMessage")
    @ResponseBody
    public R updateMessage(Message entity) {
        int i = messageService.updateMessage(entity);
        if (i > 0) {
            return R.ok().message("修改成功");
        }
        return R.error().message("修改失败");
    }
}
