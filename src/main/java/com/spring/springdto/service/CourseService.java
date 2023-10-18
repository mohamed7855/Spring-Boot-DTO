package com.spring.springdto.service;

import com.spring.springdto.model.Course;
import com.spring.springdto.model.Student;
import com.spring.springdto.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    public List<Course> getAllStudents(){
        return courseRepo.findAll();
    }
}
