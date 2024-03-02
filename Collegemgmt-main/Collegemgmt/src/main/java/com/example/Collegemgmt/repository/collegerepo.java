package com.example.Collegemgmt.repository;

import com.example.Collegemgmt.model.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface collegerepo extends JpaRepository<College, Long> {
    Optional<College> findByName(String name);
}
