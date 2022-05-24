package com.Psuti.StudentManager.Service;

import com.Psuti.StudentManager.Domain.StatinfEntity;
import com.Psuti.StudentManager.Domain.StudentGroupEntity;
import com.Psuti.StudentManager.Repository.GroupRepo;
import com.Psuti.StudentManager.Repository.StatinfRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StatinfService {
    private StatinfRepo repo;

    public List<StatinfEntity> listAll() {
        return repo.findAll();
    }

    public void save(StatinfEntity statinfEntity) {
        repo.save(statinfEntity);
    }

    public StatinfEntity get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
