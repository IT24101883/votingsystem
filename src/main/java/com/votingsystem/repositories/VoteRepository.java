package com.votingsystem.repositories;

import com.votingsystem.entities.Nominee;
import com.votingsystem.entities.User;
import com.votingsystem.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Integer> {
    Optional<Vote> findByVoterAndNominee(User voter, Nominee nominee);
    long countByNominee(Nominee nominee);
    List<Vote> findByVoter(User voter);
}
