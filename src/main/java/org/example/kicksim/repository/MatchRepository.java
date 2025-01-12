package org.example.kicksim.repository;

import org.example.kicksim.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
}
