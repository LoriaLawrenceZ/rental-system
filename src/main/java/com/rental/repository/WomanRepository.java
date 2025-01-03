package com.rental.repository;

import com.rental.Woman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WomanRepository extends JpaRepository<Woman, Integer> {
}
