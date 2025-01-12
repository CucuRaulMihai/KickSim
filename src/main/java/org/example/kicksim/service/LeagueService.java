package org.example.kicksim.service;


import org.example.kicksim.repository.LeagueRepository;
import org.springframework.stereotype.Service;

@Service
public class LeagueService {

    private final LeagueRepository leagueRepository;

    public LeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }
}
