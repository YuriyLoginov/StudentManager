package com.Psuti.StudentManager.Service;

import com.Psuti.StudentManager.Domain.SubjectEntity;
import com.Psuti.StudentManager.Repository.SubjectRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private SubjectRepo repo;

    public List<SubjectEntity> listAll() {
        return repo.findAll();
    }

    public void save(SubjectEntity subjectEntity) {
        repo.save(subjectEntity);
    }

    public SubjectEntity get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }

}
