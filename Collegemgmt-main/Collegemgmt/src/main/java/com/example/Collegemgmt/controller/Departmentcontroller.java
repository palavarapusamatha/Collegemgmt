package com.example.Collegemgmt.controller;

import com.example.Collegemgmt.model.Department;
import com.example.Collegemgmt.service.Departmentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class Departmentcontroller {
    private final Departmentservice Departmentservice;

    @Autowired
    public Departmentcontroller(Departmentservice Departmentservice) {
        this.Departmentservice = Departmentservice;
    }

    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        Department savedDepartment = Departmentservice.addDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/byCollegeName/{collegeName}")
    public ResponseEntity<List<Department>> getDepartmentsByCollegeName(@PathVariable String collegeName) {
        List<Department> departments = Departmentservice.getDepartmentsByCollegeName(collegeName);
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    // Implement other department-related operations
}

