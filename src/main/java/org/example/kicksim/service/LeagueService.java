package org.example.kicksim.service;


import org.example.kicksim.model.League;
import org.example.kicksim.repository.LeagueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueService {

    private LeagueRepository leagueRepository;

    public LeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public League save(League league) {
        return leagueRepository.save(league);
    }

    public League findById(Long id) {
        return leagueRepository.findById(id).orElseThrow(() -> new RuntimeException("League not found with id: " + id));
    }

    public List<League> findAll() {
        return leagueRepository.findAll();
    }

    public League findByName(String name) {
        return leagueRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("League not found with name: " + name));
    }

    public void deleteById(Long id) {
        if (!leagueRepository.existsById(id)) {
            throw new RuntimeException("League not found with id: " + id);
        }
        leagueRepository.deleteById(id);
    }
}
