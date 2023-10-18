package com.spring.springdto.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentResponse {

    private String name;

    // when ModelMapper run map student into StudentResponse
    //  and put phone=null because not found in student
    private String phone;
}
