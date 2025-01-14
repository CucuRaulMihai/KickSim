package org.example.kicksim.controller;


import jakarta.validation.Valid;
import org.example.kicksim.model.Stadium;
import org.example.kicksim.service.StadiumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/stadiums")
@RestController
public class StadiumController {

    private StadiumService stadiumService;

    public StadiumController(StadiumService stadiumService){
        this.stadiumService = stadiumService;
    }

    @PostMapping
    public ResponseEntity<Stadium> createStadium(@Valid @RequestBody Stadium stadium) {
        return ResponseEntity.status(HttpStatus.CREATED).body(stadiumService.save(stadium));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stadium> getStadium(@PathVariable Long id) {
        return ResponseEntity.ok(stadiumService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Stadium>> getAllStadiums() {
        return ResponseEntity.ok(stadiumService.findAll());
    }

    @GetMapping("/search")
    public ResponseEntity<Stadium> getStadiumByName(@RequestParam String name) {
        Stadium stadium = stadiumService.findByName(name);
        return ResponseEntity.ok(stadium);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStadium(@PathVariable Long id) {
        stadiumService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
