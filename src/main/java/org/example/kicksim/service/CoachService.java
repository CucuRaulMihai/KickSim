package org.example.kicksim.service;


import org.example.kicksim.model.Coach;
import org.example.kicksim.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService {

    private CoachRepository coachRepository;

    public CoachService(CoachRepository coachRepository){
        this.coachRepository = coachRepository;
    }

    // Save or Update a Coach
    public Coach save(Coach coach) {
        return coachRepository.save(coach);
    }

    // Find a Coach by ID
    public Coach findById(Long id) {
        return coachRepository.findById(id).orElse(null);
    }

    // Get All Coaches
    public List<Coach> findAll() {
        return coachRepository.findAll();
    }

    // Delete a Coach by ID
    public void deleteById(Long id) {
        coachRepository.deleteById(id);
    }

    public List<Coach> findByFirstName(String firstName) {
        return coachRepository.findByFirstName(firstName);
    }

    public List<Coach> findByLastName(String lastName) {
        return coachRepository.findByLastName(lastName);
    }

    public List<Coach> findByFirstNameAndLastName(String firstName, String lastName) {
        return coachRepository.findByFirstNameAndLastName(firstName, lastName);
    }
}
