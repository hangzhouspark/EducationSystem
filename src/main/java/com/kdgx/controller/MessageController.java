package com.kdgx.controller;

import com.kdgx.entity.Courseware;
import com.kdgx.entity.Message;
import com.kdgx.service.MessageService;
import com.kdgx.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("deleteMessage")
    @ResponseBody
    public R deleteMessage(Message entity) {
        int i = messageService.deleteMessage(entity);
        if (i > 0) {
            return R.ok().message("删除成功");
        }
        return R.error().message("删除失败");
    }
}
