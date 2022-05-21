package com.Psuti.StudentManager.Repository;

import com.Psuti.StudentManager.Domain.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<SubjectEntity, Long> {
}
