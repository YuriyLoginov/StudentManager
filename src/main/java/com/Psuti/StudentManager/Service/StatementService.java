package com.Psuti.StudentManager.Service;

import com.Psuti.StudentManager.Domain.StatementEntity;
import com.Psuti.StudentManager.Domain.StudentEntity;
import com.Psuti.StudentManager.Repository.StatementRepo;
import com.Psuti.StudentManager.Repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatementService {
    private StatementRepo repo;

    public List<StatementEntity> listAll() {
        return repo.findAll();
    }

    public void save(StatementEntity statementEntity) {
        repo.save(statementEntity);
    }

    public StatementEntity get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
