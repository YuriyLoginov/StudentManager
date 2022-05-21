package com.Psuti.StudentManager.Repository;

import com.Psuti.StudentManager.Domain.StudentGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepo extends JpaRepository<StudentGroupEntity, Long> {
}
