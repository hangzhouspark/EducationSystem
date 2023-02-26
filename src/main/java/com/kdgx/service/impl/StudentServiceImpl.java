package com.kdgx.service.impl;

import com.kdgx.entity.Student;
import com.kdgx.mapper.StudentMapper;
import com.kdgx.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;


    @Override
    public List<Student> selectStudent() {
        return studentMapper.selectStudent();
    }

    @Override
    public int insertStudent(Student entity) {
        return studentMapper.insertStudent(entity);
    }

    @Override
    public int deleteStudent(Student entity) {
        return studentMapper.deleteStudent(entity);
    }

    @Override
    public Student selectStudentBySid(Student entity) {
        return studentMapper.selectStudentBySid(entity);
    }

    @Override
    public int updateStudent(Student entity) {
        return studentMapper.updateStudent(entity);
    }
}
