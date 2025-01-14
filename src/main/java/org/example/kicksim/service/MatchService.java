package org.example.kicksim.service;


import org.example.kicksim.model.Match;
import org.example.kicksim.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository){
        this.matchRepository = matchRepository;
    }


    // Save or Update a Match
    public Match save(Match match) {
        return matchRepository.save(match);
    }

    // Find a Match by ID
    public Match findById(Long id) {
        return matchRepository.findById(id).orElse(null);
    }

    // Get All Matches
    public List<Match> findAll() {
        return matchRepository.findAll();
    }

    // Delete a Match by ID
    public void deleteById(Long id) {
        matchRepository.deleteById(id);
    }

}
