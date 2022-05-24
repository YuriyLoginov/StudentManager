package com.Psuti.StudentManager.Repository;

import com.Psuti.StudentManager.Domain.StatinfEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatinfRepo extends JpaRepository<StatinfEntity, Long> {
}
