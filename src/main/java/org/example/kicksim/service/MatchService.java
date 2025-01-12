package org.example.kicksim.service;


import org.example.kicksim.repository.MatchRepository;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository){
        this.matchRepository = matchRepository;
    }

}
