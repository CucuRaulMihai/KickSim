package org.example.kicksim.repository;

import org.example.kicksim.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    // Find players with skill level greater than the specified value
    List<Player> findBySkillLevelGreaterThan(Double skillLevel);

    // With the lower skill value, as the name suggests
    List<Player> findBySkillLevelLessThan(Double skillLevel);

    // Find players with skill level in a range
    List<Player> findBySkillLevelBetween(Double start, Double end);
}
