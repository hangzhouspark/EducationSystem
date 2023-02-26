package com.kdgx.mapper;

import com.kdgx.entity.Student;

import java.util.List;

public interface StudentMapper {
    /**
     * 查询学生信息
     *
     * @return
     */
    public List<Student> selectStudent();

    /**
     * 新增学生信息
     *
     * @param entity
     * @return
     */
    public int insertStudent(Student entity);

    /**
     * 删除学生信息
     *
     * @param entity
     * @return
     */
    public int deleteStudent(Student entity);

    /**
     * 根据ID查询信息
     *
     * @param entity
     * @return
     */
    public Student selectStudentBySid(Student entity);

    /**
     * 修改学生信息
     *
     * @param entity
     * @return
     */
    public int updateStudent(Student entity);
}
