package com.votingsystem.repositories;

import com.votingsystem.entities.AwardCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AwardCategoryRepository extends JpaRepository<AwardCategory, Integer> {
    boolean existsByName(String name);
}
