package com.spring.springdto.service;

import com.spring.springdto.model.Course;
import com.spring.springdto.model.CourseDTO;
import com.spring.springdto.model.Student;
import com.spring.springdto.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    public List<CourseDTO> getAllCourses(){
        List<Course> courses = courseRepo.findAll();
        List<CourseDTO> courseDTOS = new ArrayList<>();

        for (Course course : courses){
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setId(course.getId());
            courseDTO.setName(course.getName());
            courseDTOS.add(courseDTO);
        }

        return courseDTOS;
    }

    public List<Course> getAllCoursesAfterRelation(){
        return courseRepo.findAll();
    }
}
