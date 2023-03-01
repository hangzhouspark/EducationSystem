package com.kdgx.service.impl;

import com.kdgx.entity.Courseware;
import com.kdgx.mapper.CoursewareMapper;
import com.kdgx.service.CoursewareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursewareServiceImpl implements CoursewareService {
    @Autowired
    private CoursewareMapper coursewareMapper;

    @Override
    public List<Courseware> selectCourseware() {
        return coursewareMapper.selectCourseware();
    }

    @Override
    public Courseware selectCoursewareByCid(Courseware entity) {
        return coursewareMapper.selectCoursewareByCid(entity);
    }

    @Override
    public int insertCourseware(Courseware entity) {
        return coursewareMapper.insertCourseware(entity);
    }

    @Override
    public int deleteCourseware(Courseware entity) {
        return coursewareMapper.deleteCourseware(entity);
    }

    @Override
    public int updateCourseware(Courseware entity) {
        return coursewareMapper.updateCourseware(entity);
    }

    @Override
    public int updateCoursewareByCware(Courseware entity) {
        return coursewareMapper.updateCoursewareByCware(entity);
    }


}
