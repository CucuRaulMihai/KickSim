package org.example.kicksim.repository;

import org.example.kicksim.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
}
