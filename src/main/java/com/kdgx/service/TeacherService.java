package com.kdgx.service;

import com.kdgx.entity.Teacher;

import java.util.List;

public interface TeacherService {
    /**
     * 查询老师信息
     *
     * @return
     */
    public List<Teacher> selectTeacher();

    /**
     * 新增老师信息
     *
     * @param entity
     * @return
     */
    public int insertTeacher(Teacher entity);

    /**
     * 删除老师信息
     *
     * @param entity
     * @return
     */
    public int deleteTeacher(Teacher entity);

    /**
     * 根据ID查询老师信息
     *
     * @param entity
     * @return
     */
    public Teacher selectTeacherByTid(Teacher entity);

    /**
     * 修改老师信息
     *
     * @param entity
     * @return
     */
    public int updateTeacher(Teacher entity);
}
