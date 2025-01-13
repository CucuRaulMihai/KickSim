package org.example.kicksim.controller;


import org.example.kicksim.service.PlayerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/player")
@RestController
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }
}
