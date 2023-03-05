package com.kdgx.mapper;

import com.kdgx.entity.Message;

import java.util.List;

public interface MessageMapper {
    /**
     * 查询问答信息
     * @return
     */
    public List<Message> selectMessage();

    /**
     * 删除问答信息
     *
     */
    public int deleteMessage(Message entity);
}
