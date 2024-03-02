package com.example.Collegemgmt.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "college_id")
    private College college;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Faculty> faculties;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hod_id", referencedColumnName = "id")
    private Faculty hod;

    // Constructors, getters, setters

    public void assignHod(Faculty hod) {
        this.hod = hod;
        hod.setDepartment(this);
    }
}
