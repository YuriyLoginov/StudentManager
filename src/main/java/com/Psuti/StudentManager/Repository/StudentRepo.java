package com.Psuti.StudentManager.Repository;

import com.Psuti.StudentManager.Domain.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Long> {

    @Query(value = "select s.id, s.group_id from student s INNER JOIN group g ON s.group = g.id", nativeQuery = true)
    List<Object[]> findStudent();
}
