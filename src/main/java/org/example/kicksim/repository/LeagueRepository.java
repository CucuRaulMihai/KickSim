package org.example.kicksim.repository;

import org.example.kicksim.model.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {
}
