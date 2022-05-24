package com.Psuti.StudentManager.Service;

import com.Psuti.StudentManager.Domain.StatementEntity;
import com.Psuti.StudentManager.Domain.StudentGroupEntity;
import com.Psuti.StudentManager.Repository.GroupRepo;
import com.Psuti.StudentManager.Repository.StatementRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GroupService {
    private GroupRepo repo;

    public List<StudentGroupEntity> listAll() {
        return repo.findAll();
    }

    public void save(StudentGroupEntity studentGroupEntity) {
        repo.save(studentGroupEntity);
    }

    public StudentGroupEntity get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
