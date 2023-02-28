package com.kdgx.service.impl;

import com.kdgx.mapper.CoursewareMapper;
import com.kdgx.service.CoursewareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoursewareServiceImpl implements CoursewareService {
    @Autowired
    private CoursewareMapper coursewareMapper;
}
