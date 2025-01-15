package org.example.kicksim.controller;


import org.example.kicksim.model.Coach;
import org.example.kicksim.service.CoachService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/coaches")
@RestController
public class CoachController {

    private CoachService coachService;

    public CoachController(CoachService coachService){
        this.coachService = coachService;
    }

    // Create a Coach
    @PostMapping
    public ResponseEntity<Coach> createCoach(@RequestBody Coach coach) {
        return ResponseEntity.status(HttpStatus.CREATED).body(coachService.save(coach));
    }

    // Get a Coach by ID
    @GetMapping("/{id}")
    public ResponseEntity<Coach> getCoachById(@PathVariable Long id) {
        Coach coach = coachService.findById(id);
        return coach != null ? ResponseEntity.ok(coach) : ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Coach>> searchCoaches(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {

        List<Coach> coaches;

        if (firstName != null && lastName != null) {
            coaches = coachService.findByFirstNameAndLastName(firstName, lastName);
        } else if (firstName != null) {
            coaches = coachService.findByFirstName(firstName);
        } else if (lastName != null) {
            coaches = coachService.findByLastName(lastName);
        } else {
            return ResponseEntity.badRequest().build(); // No query parameters provided
        }

        return ResponseEntity.ok(coaches);
    }

    // Get All Coaches
    @GetMapping
    public ResponseEntity<List<Coach>> getAllCoaches() {
        return ResponseEntity.ok(coachService.findAll());
    }

    // Delete a Coach by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable Long id) {
        coachService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
