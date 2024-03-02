package com.example.Collegemgmt.service;
import com.example.Collegemgmt.model.Department;
import com.example.Collegemgmt.model.Faculty;
import com.example.Collegemgmt.repository.departmentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Departmentservice {
    private final departmentrepo departmentrepo;

    @Autowired
    public Departmentservice(departmentrepo departmentrepo) {
        this.departmentrepo = departmentrepo;
    }

    public Department addDepartment(Department department) {
        return departmentrepo.save(department);
    }

    public List<Department> getDepartmentsByCollegeName(String collegeName) {
        return departmentrepo.findByCollegeName(collegeName);
    }

    public Department getDepartmentById(Long id) {
        return departmentrepo.findById(id).orElse(null);
    }

    public void assignHodToDepartment(Long departmentId, Faculty hod) {
        Department department = departmentrepo.findById(departmentId).orElse(null);
        if (department != null) {
            department.assignHod(hod);
            departmentrepo.save(department);
        }
    }
}


