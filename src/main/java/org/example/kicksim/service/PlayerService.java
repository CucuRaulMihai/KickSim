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

    // Get All Players
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    // Delete a Player by ID
    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }
}
