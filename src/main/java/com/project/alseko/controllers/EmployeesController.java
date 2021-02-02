package com.project.alseko.controllers;

import com.project.alseko.dto.EmployeesDto;
import com.project.alseko.dto.ResponseDto;
import com.project.alseko.servises.EmployeesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employees")
@CrossOrigin
public class EmployeesController {

    private final EmployeesService employeesService;

    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeesDto> addEmployees(@RequestBody EmployeesDto employeesDto) {
        return ResponseEntity.ok(employeesService.addEmployees(employeesDto));
    }

    @GetMapping("/find")
    public Page<ResponseDto> findAll(Pageable pageable) {
        return employeesService.findAll(pageable);
    }

    @GetMapping("/find/{id}")
    public EmployeesDto findByIdEmployees(@PathVariable Integer id) {

        return employeesService.findByIdEmployees(id);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeesDto> updateEmployees(@RequestBody EmployeesDto employeesDto) {
        return ResponseEntity.ok(employeesService.updateEmployees(employeesDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployees(@PathVariable Integer id) {
        employeesService.deleteEmployees(id);
        return ResponseEntity.ok().build();
    }

}
