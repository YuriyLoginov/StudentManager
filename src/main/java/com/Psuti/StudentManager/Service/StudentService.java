package com.Psuti.StudentManager.Service;

import com.Psuti.StudentManager.Domain.StudentEntity;
import com.Psuti.StudentManager.Domain.SubjectEntity;
import com.Psuti.StudentManager.Repository.StudentRepo;
import com.Psuti.StudentManager.Repository.SubjectRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private StudentRepo repo;

    public List<StudentEntity> listAll() {
        return repo.findAll();
    }

    public void save(StudentEntity studentEntity) {
        repo.save(studentEntity);
    }

    public StudentEntity get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
