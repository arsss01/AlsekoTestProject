package com.project.alseko.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    private Integer employeeId;
    private String surname;
    private String name;
    private String patronymic;
    private Integer quantity;
    private Long commonCost = 0L;

    public void setCommonCost(Long commonCost) {
        this.commonCost += commonCost;
    }
}
