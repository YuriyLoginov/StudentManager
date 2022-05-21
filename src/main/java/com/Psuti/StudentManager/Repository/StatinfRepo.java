package com.Psuti.StudentManager.Repository;

import com.Psuti.StudentManager.Domain.StatinfEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatinfRepo extends JpaRepository<StatinfEntity, Long> {
}
