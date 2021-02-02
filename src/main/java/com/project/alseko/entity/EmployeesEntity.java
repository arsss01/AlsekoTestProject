package com.project.alseko.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "employees")
public class EmployeesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String surname;
    private String name;
    private String patronymic;
    private String email;
    private String gender;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employees_material_values",
            joinColumns = @JoinColumn(name = "employees_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "material_id", referencedColumnName = "id"))
    private List<MaterialValuesEntity> materialValues;

}
