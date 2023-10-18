package com.spring.springdto.service;

import com.spring.springdto.model.Student;
import com.spring.springdto.model.StudentDTO;
import com.spring.springdto.model.StudentResponse;
import com.spring.springdto.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<StudentDTO> getAllStudents(){
        List<Student> students = studentRepo.findAll();
        List<StudentDTO> studentDTOS = new ArrayList<>();

        for (Student student : students){
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(student.getId());
            studentDTO.setName(student.getName());
            studentDTOS.add(studentDTO);
        }

        return studentDTOS;

    }

    public StudentResponse getStudent(Long id){
        Student student = studentRepo.findById(id).get();
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setName(student.getName());

        return studentResponse;
    }
}
