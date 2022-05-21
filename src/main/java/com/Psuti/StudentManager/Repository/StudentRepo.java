package com.Psuti.StudentManager.Repository;

import com.Psuti.StudentManager.Domain.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepo extends JpaRepository<StudentEntity, Long> {
}
