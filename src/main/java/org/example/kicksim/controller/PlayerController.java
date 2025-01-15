package org.example.kicksim.controller;


import jakarta.validation.Valid;
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
    public ResponseEntity<Player> createPlayer(@Valid @RequestBody Player player) {
        return ResponseEntity.status(HttpStatus.CREATED).body(playerService.save(player));
    }

    // Update a Player
    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @Valid @RequestBody Player player) {
        Player existingPlayer = playerService.findById(id);
        if (existingPlayer == null) {
            return ResponseEntity.notFound().build();
        }
        player.setId(id); // Ensure the ID is preserved
        return ResponseEntity.ok(playerService.save(player));
    }

    // Get a Player by ID
    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        Player player = playerService.findById(id);
        return player != null ? ResponseEntity.ok(player) : ResponseEntity.notFound().build();
    }

    // Get players with skill level greater than the specified value
    @GetMapping("/search/skill/greater")
    public ResponseEntity<List<Player>> getPlayersWithSkillLevelGreaterThan(@RequestParam Double skillLevel) {
        List<Player> players = playerService.findPlayersWithSkillLevelGreaterThan(skillLevel);
        return ResponseEntity.ok(players);
    }

    @GetMapping("/search/skill/lower")
    public ResponseEntity<List<Player>> getPlayersWithSkillLevelLowerThan(@RequestParam Double skillLevel){
        List<Player> players = playerService.findPlayersWithSkillLevelLessThan(skillLevel);
        return ResponseEntity.ok(players);
    }

    // Get players with skill level in a range
    @GetMapping("/search/skill/range")
    public ResponseEntity<List<Player>> getPlayersWithSkillLevelInRange(
            @RequestParam Double start,
            @RequestParam Double end) {
        List<Player> players = playerService.findPlayersWithSkillLevelInRange(start, end);
        return ResponseEntity.ok(players);
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
