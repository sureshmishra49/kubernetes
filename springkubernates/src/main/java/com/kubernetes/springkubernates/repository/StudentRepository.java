package com.kubernetes.springkubernates.repository;

import com.kubernetes.springkubernates.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
