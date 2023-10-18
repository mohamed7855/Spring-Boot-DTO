package com.spring.springdto.controller;

import com.spring.springdto.model.Student;
import com.spring.springdto.model.StudentDTO;
import com.spring.springdto.model.StudentResponse;
import com.spring.springdto.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/allStudents")
    public List<StudentDTO> getAllStudents(){
        return studentService.getAllStudents();
    }

    // http://localhost:8080/student/allStudentsAfterRelation
    @GetMapping("/allStudentsAfterRelation")
    public List<Student> allStudentsAfterRelation(){
        return studentService.getAllStudentsAfterRelation();
    }

    // http://localhost:8080/student/getStudent?id=1
    @GetMapping("/getStudent")
    public StudentResponse getStudent(@RequestParam("id") Long id){
        return studentService.getStudent(id);
    }
}
