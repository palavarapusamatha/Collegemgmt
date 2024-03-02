package com.example.Collegemgmt.controller;

import com.example.Collegemgmt.model.College;
import com.example.Collegemgmt.service.Collegeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colleges")
public class Collegecontroller {
    private final Collegeservice Collegeservice;

    @Autowired
    public Collegecontroller(Collegeservice Collegeservice) {
        this.Collegeservice = Collegeservice;
    }

    @PostMapping
    public ResponseEntity<College> addCollege(@RequestBody College college) {
        College savedCollege = Collegeservice.addCollege(college);
        return new ResponseEntity<>(savedCollege, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<College>> getAllColleges() {
        List<College> colleges = Collegeservice.getAllColleges();
        return new ResponseEntity<>(colleges, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<College> getCollegeById(@PathVariable Long id) {
        College college = Collegeservice.getCollegeById(id);
        return new ResponseEntity<>(college, HttpStatus.OK);
    }

    // Implement other CRUD operations as needed
}
