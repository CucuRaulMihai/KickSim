package org.example.kicksim.service;


import org.example.kicksim.repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }
}
