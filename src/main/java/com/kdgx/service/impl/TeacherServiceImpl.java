package com.kdgx.service.impl;

import com.kdgx.entity.Teacher;
import com.kdgx.mapper.TeacherMapper;
import com.kdgx.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> selectTeacher() {
        return teacherMapper.selectTeacher();
    }

    @Override
    public int insertTeacher(Teacher entity) {
        return teacherMapper.insertTeacher(entity);
    }

    @Override
    public int deleteTeacher(Teacher entity) {
        return teacherMapper.deleteTeacher(entity);
    }

    @Override
    public Teacher selectTeacherByTid(Teacher entity) {
        return teacherMapper.selectTeacherByTid(entity);
    }

    @Override
    public int updateTeacher(Teacher entity) {
        return teacherMapper.updateTeacher(entity);
    }
}
