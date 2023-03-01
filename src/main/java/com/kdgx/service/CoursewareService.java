package com.kdgx.service;

import com.kdgx.entity.Courseware;

import java.util.List;

public interface CoursewareService {
    /**
     * 查询所有课件信息
     *
     * @return
     */
    public List<Courseware> selectCourseware();

    /**
     * 查询ID查询课件信息
     *
     * @return
     */
    public Courseware selectCoursewareByCid(Courseware entity);

    /**
     * 添加课件信息
     *
     * @return
     */
    public int insertCourseware(Courseware entity);

    /**
     * 删除课件信息
     *
     * @return
     */
    public int deleteCourseware(Courseware entity);

    /**
     * 修改出课件外的课件信息
     *
     * @return
     */
    public int updateCourseware(Courseware entity);

    /**
     * 修改课件
     *
     * @return
     */
    public int updateCoursewareByCware(Courseware entity);
}
