package com.spring.springdto.model;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CourseDTO {

    // specific data that u want to return
    @Id
    private Long id;

    private String name;
}
