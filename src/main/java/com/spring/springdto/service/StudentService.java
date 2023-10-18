package com.spring.springdto.service;

import com.spring.springdto.model.*;
import com.spring.springdto.repository.CourseRepo;
import com.spring.springdto.repository.StudentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StudentRepo studentRepo;

    public List<StudentDTO> getAllStudents(){
        List<Student> students = studentRepo.findAll();
        List<StudentDTO> studentDTOS = new ArrayList<>();

        for (Student student : students){
            StudentDTO studentDTO = modelMapper.map(student,StudentDTO.class);
//            studentDTO.setId(student.getId());
//            studentDTO.setName(student.getName());
            studentDTOS.add(studentDTO);
        }

        return studentDTOS;

    }

    public List<Student> getAllStudentsAfterRelation(){
        return studentRepo.findAll();
    }

    public StudentResponse getStudent(Long id){
        Student student = studentRepo.findById(id).get();

        // using modelMapper: attribute name must same in source and destination
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setPhone("44444444");
        modelMapper.map(student,studentResponse);
        // StudentResponse studentResponse = modelMapper.map(student,StudentResponse.class);
        // studentResponse.setPhone("4444444");

        return studentResponse;
    }

    public DtoStudentCourse getStudentCourses(List<Long> ids) {
        DtoStudentCourse dtoStudentCourse = new DtoStudentCourse();
        Student student = courseRepo.findStudentByCourseId(ids.get(0));
        dtoStudentCourse.setId(student.getId());
        dtoStudentCourse.setName(student.getName());

        List<Course> courses= courseRepo.listCoursesInIds(ids);
        for (Course course:courses) {
            DtoCourse dtoCourse = new DtoCourse();
            dtoCourse.setId(course.getId());
            dtoCourse.setCost(course.getCost());
            dtoStudentCourse.getCourses().add(dtoCourse);
        }
        return dtoStudentCourse;
    }
}
