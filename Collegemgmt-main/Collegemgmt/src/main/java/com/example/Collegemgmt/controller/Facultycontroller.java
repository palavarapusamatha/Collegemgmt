package com.example.Collegemgmt.controller;
import com.example.Collegemgmt.service.Facultyservice;  // Make sure the package and class names are correct

import com.example.Collegemgmt.model.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculties")
public class Facultycontroller {
    private final Facultyservice Facultyservice;

    @Autowired
    public Facultycontroller(Facultyservice Facultyservice) {
        this.Facultyservice = Facultyservice;
    }

    @PostMapping
    public ResponseEntity<Faculty> addFaculty(@RequestBody Faculty faculty) {
        Faculty savedFaculty = Facultyservice.addFaculty(faculty);
        return new ResponseEntity<>(savedFaculty, HttpStatus.CREATED);
    }

    @GetMapping("/byDepartmentName/{departmentName}")
    public ResponseEntity<List<Faculty>> getFacultiesByDepartmentName(@PathVariable String departmentName) {
        List<Faculty> faculties = Facultyservice.getFacultiesByDepartmentName(departmentName);
        return new ResponseEntity<>(faculties, HttpStatus.OK);
    }

    // Implement other faculty-related operations
}
