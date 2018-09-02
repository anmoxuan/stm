package com.springboot.service;

import com.springboot.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    public List findAll(){
        return studentMapper.findAll();
    }
}
