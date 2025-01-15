package org.example.kicksim.controller;


import org.example.kicksim.model.Player;
import org.example.kicksim.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/players")
@RestController
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    // Create a Player
    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        return ResponseEntity.status(HttpStatus.CREATED).body(playerService.save(player));
    }

    // Get a Player by ID
    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        Player player = playerService.findById(id);
        return player != null ? ResponseEntity.ok(player) : ResponseEntity.notFound().build();
    }

    // Get All Players
    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        return ResponseEntity.ok(playerService.findAll());
    }

    // Delete a Player by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        playerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
