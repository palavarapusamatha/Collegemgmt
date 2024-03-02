package com.example.Collegemgmt.service;
import org.springframework.stereotype.Service;



import com.example.Collegemgmt.model.College;
import com.example.Collegemgmt.repository.collegerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Collegeservice {

    private final collegerepo collegerepo;

    @Autowired
    public Collegeservice(collegerepo collegerepo) {
        this.collegerepo = collegerepo;
    }

    public College addCollege(College college) {
        return collegerepo.save(college);
    }

    public List<College> getAllColleges() {
        return collegerepo.findAll();
    }

    public College getCollegeById(Long id) {
        return collegerepo.findById(id).orElse(null);
    }

    public void updateCollegeName(Long collegeId, String newName) {
        College college = collegerepo.findById(collegeId).orElse(null);
        if (college != null) {
            college.setName(newName);
            collegerepo.save(college);
        }
    }

    public void deleteCollegeById(Long id) {
        collegerepo.deleteById(id);
    }
}
