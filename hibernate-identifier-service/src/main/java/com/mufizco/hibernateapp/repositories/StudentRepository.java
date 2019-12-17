package com.mufizco.hibernateapp.repositories;

import com.mufizco.hibernateapp.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
