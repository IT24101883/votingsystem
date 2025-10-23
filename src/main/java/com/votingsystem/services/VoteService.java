package com.votingsystem.services;

import com.votingsystem.entities.Nominee;
import com.votingsystem.entities.User;
import com.votingsystem.entities.Vote;
import com.votingsystem.repositories.VoteRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VoteService {
    private final VoteRepository repo;
    public VoteService(VoteRepository repo){ this.repo = repo; }

    public List<Vote> getAll() { return repo.findAll(); }
    public Optional<Vote> getById(Integer id) { return repo.findById(id); }
    public Vote create(Vote v){
        if (v.getVoteTime() == null) v.setVoteTime(LocalDateTime.now());
        return repo.save(v);
    }
    public Vote update(Integer id, Vote v){
        return repo.findById(id).map(existing -> {
            existing.setNominee(v.getNominee());
            existing.setVoter(v.getVoter());
            return repo.save(existing);
        }).orElse(null);
    }
    public void delete(Integer id) { repo.deleteById(id); }

    public Optional<Vote> findByVoterAndNominee(User voter, Nominee nominee){
        return repo.findByVoterAndNominee(voter, nominee);
    }
    public long countByNominee(Nominee nominee){ return repo.countByNominee(nominee); }
    public List<Vote> findByVoter(User voter){ return repo.findByVoter(voter); }
}
