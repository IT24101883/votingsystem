package com.votingsystem.repositories;

import com.votingsystem.entities.Result;
import com.votingsystem.entities.AwardCategory;
import com.votingsystem.entities.Nominee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Integer> {
    List<Result> findByAwardCategory(AwardCategory awardCategory);
    List<Result> findByNominee(Nominee nominee);
}
