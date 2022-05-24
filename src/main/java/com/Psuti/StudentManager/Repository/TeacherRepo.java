package com.Psuti.StudentManager.Repository;

import com.Psuti.StudentManager.Domain.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<TeacherEntity, Long> {
}
