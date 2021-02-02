package com.project.alseko.dto;

import lombok.Data;

import java.util.List;

@Data
public class EmployeesDto {

    private Integer id;
    private String name;
    private String surname;
    private String patronymic;
    private String email;
    private String gender;
    private List<MaterialValuesDto> materialValues;

}
