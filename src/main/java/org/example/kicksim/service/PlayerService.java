package org.example.kicksim.service;


import org.example.kicksim.model.Player;
import org.example.kicksim.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    // Save or Update a Player
    public Player save(Player player) {
        return playerRepository.save(player);
    }

    // Find a Player by ID
    public Player findById(Long id) {
        return playerRepository.findById(id).orElse(null);
    }

    // Fetch players with skill level greater than the specified value
    public List<Player> findPlayersWithSkillLevelGreaterThan(Double skillLevel) {
        return playerRepository.findBySkillLevelGreaterThan(skillLevel);
    }

    // I mean, what does the name even tell you?
    public List<Player> findPlayersWithSkillLevelLessThan(Double skillLevel) {
        return playerRepository.findBySkillLevelLessThan(skillLevel);
    }

    // Fetch players with skill level in a range
    public List<Player> findPlayersWithSkillLevelInRange(Double start, Double end) {
        // Ensure start is the lower bound and end is the upper bound
        Double lowerBound = Math.min(start, end);
        Double upperBound = Math.max(start, end);

        return playerRepository.findBySkillLevelBetween(lowerBound, upperBound);
    }

    // Get All Players
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    // Delete a Player by ID
    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }
}
