package com.Psuti.StudentManager.Service;

import com.Psuti.StudentManager.Domain.SubjectEntity;
import com.Psuti.StudentManager.Domain.TeacherEntity;
import com.Psuti.StudentManager.Repository.SubjectRepo;
import com.Psuti.StudentManager.Repository.TeacherRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {
    private TeacherRepo repo;

    public List<TeacherEntity> listAll() {
        return repo.findAll();
    }

    public void save(TeacherEntity teacherEntity) {
        repo.save(teacherEntity);
    }

    public TeacherEntity get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
