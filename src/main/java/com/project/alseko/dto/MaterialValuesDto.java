package com.project.alseko.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MaterialValuesDto {

    private Integer id;
    private String category;
    private String name;
    private Date date;
    private long cost;

}
