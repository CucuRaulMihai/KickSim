package org.example.kicksim.service;


import org.example.kicksim.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoachService {

    private CoachRepository coachRepository;

    public CoachService(CoachRepository coachRepository){
        this.coachRepository = coachRepository;
    }
}
