package org.example.kicksim.controller;


import org.example.kicksim.model.League;
import org.example.kicksim.service.LeagueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/leagues")
@RestController
public class LeagueController {

    private LeagueService leagueService;

    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<League> createLeague(@RequestBody League league) {
        System.out.println(league.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(leagueService.save(league));
    }

    @GetMapping("/{id}")
    public ResponseEntity<League> getLeague(@PathVariable Long id) {
        League league = leagueService.findById(id);
        return ResponseEntity.ok(league);
    }

    @GetMapping("/search")
    public ResponseEntity<League> getLeagueByName(@RequestParam String name) {
        League league = leagueService.findByName(name);
        return ResponseEntity.ok(league);
    }

    @GetMapping
    public ResponseEntity<List<League>> getAllLeagues() {
        return ResponseEntity.ok(leagueService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeague(@PathVariable Long id) {
        leagueService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
