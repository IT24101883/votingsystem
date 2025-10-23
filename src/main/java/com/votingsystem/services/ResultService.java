package com.votingsystem.services;

import com.votingsystem.entities.Result;
import com.votingsystem.entities.AwardCategory;
import com.votingsystem.entities.Nominee;
import com.votingsystem.repositories.ResultRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ResultService {
    private final ResultRepository repo;
    public ResultService(ResultRepository repo){ this.repo = repo; }

    public List<Result> getAll() { return repo.findAll(); }
    public Optional<Result> getById(Integer id) { return repo.findById(id); }
    public Result create(Result r) { return repo.save(r); }
    public Result update(Integer id, Result r){
        return repo.findById(id).map(existing -> {
            existing.setTotalVotes(r.getTotalVotes());
            return repo.save(existing);
        }).orElse(null);
    }
    public void delete(Integer id) { repo.deleteById(id); }

    public List<Result> getByAward(AwardCategory ac){ return repo.findByAwardCategory(ac); }
    public List<Result> getByNominee(Nominee n){ return repo.findByNominee(n); }
}
