package com.votingsystem.repositories;

import com.votingsystem.entities.Nominee;
import com.votingsystem.entities.AwardCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NomineeRepository extends JpaRepository<Nominee, Integer> {
    List<Nominee> findByAwardCategory(AwardCategory awardCategory);
}
