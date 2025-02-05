package org.example.kicksim.repository;


import org.example.kicksim.model.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long> {

    Optional<Stadium> findByName(String name);
}
