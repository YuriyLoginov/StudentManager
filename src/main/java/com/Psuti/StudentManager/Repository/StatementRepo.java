package com.Psuti.StudentManager.Repository;

import com.Psuti.StudentManager.Domain.StatementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatementRepo extends JpaRepository<StatementEntity, Long> {
}
