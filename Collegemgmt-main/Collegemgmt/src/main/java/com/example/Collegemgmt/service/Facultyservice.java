package com.example.Collegemgmt.service;
import com.example.Collegemgmt.repository.facultyrepo;  // Make sure the package and class names are correct
import com.example.Collegemgmt.model.Department;
import com.example.Collegemgmt.model.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Facultyservice {
    private final facultyrepo facultyrepo;
    private final Departmentservice Departmentservice;

    @Autowired
    public Facultyservice(facultyrepo facultyrepo, Departmentservice Departmentservice) {
        this.facultyrepo = facultyrepo;
        this.Departmentservice = Departmentservice;
    }

    public Faculty addFaculty(Faculty faculty) {
        // Implement the logic to add a new faculty
        return facultyrepo.save(faculty);
    }

    public List<Faculty> getFacultiesByDepartmentName(String departmentName) {
        // Implement the logic to retrieve faculties by department name
        return facultyrepo.findByDepartmentName(departmentName);
    }

    public List<Faculty> getHodFaculties() {
        // Implement the logic to retrieve faculties who are HODs
        return facultyrepo.findByDepartmentNameAndHodIsNotNull("HOD Department");
    }

    public void assignFacultyToDepartment(Long facultyId, Long departmentId) {
        // Implement the logic to assign a faculty to a department
        Faculty faculty = facultyrepo.findById(facultyId).orElse(null);
        Department department = Departmentservice.getDepartmentById(departmentId);

        if (faculty != null && department != null) {
            faculty.setDepartment(department);
            facultyrepo.save(faculty);
        }
    }

    // Add other faculty-related operations as needed
}


