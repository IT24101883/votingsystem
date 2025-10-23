package com.votingsystem.services;

import com.votingsystem.entities.Nominee;
import com.votingsystem.entities.AwardCategory;
import com.votingsystem.repositories.NomineeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NomineeService {
    private final NomineeRepository repo;
    public NomineeService(NomineeRepository repo){ this.repo = repo; }

    public List<Nominee> getAll() { return repo.findAll(); }
    public Optional<Nominee> getById(Integer id) { return repo.findById(id); }
    public Nominee create(Nominee n) { return repo.save(n); }
    public Nominee update(Integer id, Nominee n){
        return repo.findById(id).map(existing -> {
            existing.setAwardCategory(n.getAwardCategory());
            return repo.save(existing);
        }).orElse(null);
    }
    public void delete(Integer id) { repo.deleteById(id); }
    public List<Nominee> getByAward(AwardCategory ac){ return repo.findByAwardCategory(ac); }
}
