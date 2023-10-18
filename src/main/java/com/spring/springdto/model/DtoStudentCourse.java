package com.spring.springdto.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class DtoStudentCourse {

    private Long id;

    private String name;

    private List<DtoCourse> courses = new ArrayList<>();
}
