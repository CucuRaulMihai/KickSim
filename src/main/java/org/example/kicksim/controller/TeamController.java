package org.example.kicksim.controller;


import jakarta.validation.Valid;
import org.example.kicksim.model.League;
import org.example.kicksim.model.Stadium;
import org.example.kicksim.model.Team;
import org.example.kicksim.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/teams")
@RestController
public class TeamController {

    private TeamService teamService;
    private LeagueService leagueService;
    private StadiumService stadiumService;
    private CoachService coachService;
    private PlayerService playerService;

    public TeamController(TeamService teamService, LeagueService leagueService, StadiumService stadiumService, CoachService coachService, PlayerService playerService) {
        this.teamService = teamService;
        this.leagueService = leagueService;
        this.stadiumService = stadiumService;
        this.coachService = coachService;
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<Team> createTeam(@Valid @RequestBody Team team) {
        // Ensure the league is fetched from the database
        League league = leagueService.findById(team.getLeague().getId());
        team.setLeague(league);
        return ResponseEntity.status(HttpStatus.CREATED).body(teamService.save(team));
    }

    // Update an existing team
    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable Long id, @RequestBody Team updatedTeam) {
        // Fetch the existing team
        Team existingTeam = teamService.findById(id);
        if (existingTeam == null) {
            return ResponseEntity.notFound().build();
        }

        // Fetch and validate the stadium if provided
        if (updatedTeam.getStadium() != null) {
            Stadium stadium = stadiumService.findById(updatedTeam.getStadium().getId());
            if (stadium == null) {
                return ResponseEntity.badRequest().body(null);
            }

            // Set the homeTeam reference in the Stadium
            stadium.setHomeTeam(existingTeam);
            existingTeam.setStadium(stadium); // Update the stadium reference in the team
        }

        // Update other fields
        existingTeam.setTeamName(updatedTeam.getTeamName());
        existingTeam.setTeamNationality(updatedTeam.getTeamNationality());
        existingTeam.setYearFounded(updatedTeam.getYearFounded());

        // Save and return the updated team
        return ResponseEntity.ok(teamService.save(existingTeam));
    }

    @GetMapping("/search")
    public ResponseEntity<Team> getTeamByName(@RequestParam String name) {
        Team team = teamService.findByTeamName(name);
        return ResponseEntity.ok(team);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeam(@PathVariable Long id) {
        Team team = teamService.findById(id);
        return team != null ? ResponseEntity.ok(team) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        return ResponseEntity.ok(teamService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        teamService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
