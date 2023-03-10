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

    /**
     * 根据ID查询
     */
    public Message selectMessageBymid(Message entity);


    /**
     * 修改答案
     * @param entity
     * @return
     */
    public int updateMessage(Message entity);

    /**
     * 添加问题
     */
    public int insertQuesByStudent(Message entity);

}
