package com.example.Collegemgmt.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "college")
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
    private List<Department> departments;

    // Constructors, getters, setters
}

