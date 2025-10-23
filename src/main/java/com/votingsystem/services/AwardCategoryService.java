package com.votingsystem.services;

import com.votingsystem.entities.AwardCategory;
import com.votingsystem.repositories.AwardCategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AwardCategoryService {
    private final AwardCategoryRepository repo;
    public AwardCategoryService(AwardCategoryRepository repo){ this.repo = repo; }

    public List<AwardCategory> getAll() { return repo.findAll(); }
    public Optional<AwardCategory> getById(Integer id) { return repo.findById(id); }
    public AwardCategory create(AwardCategory a) { return repo.save(a); }
    public AwardCategory update(Integer id, AwardCategory a){
        return repo.findById(id).map(existing -> {
            existing.setName(a.getName());
            existing.setDescription(a.getDescription());
            return repo.save(existing);
        }).orElse(null);
    }
    public void delete(Integer id) { repo.deleteById(id); }
}
