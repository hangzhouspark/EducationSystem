package com.kdgx.service.impl;

import com.kdgx.entity.Message;
import com.kdgx.mapper.MessageMapper;
import com.kdgx.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Message> selectMessage() {
        return messageMapper.selectMessage();
    }

    @Override
    public int deleteMessage(Message entity) {
        return messageMapper.deleteMessage(entity);
    }

    @Override
    public Message selectMessageBymid(Message entity) {
        return messageMapper.selectMessageBymid(entity);
    }


    @Override
    public int updateMessage(Message entity) {
        return messageMapper.updateMessage(entity);
    }

    @Override
    public int insertQuesByStudent(Message entity) {
        return messageMapper.insertQuesByStudent(entity);
    }
}
