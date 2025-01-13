package org.example.kicksim.service;


import org.example.kicksim.repository.StadiumRepository;
import org.springframework.stereotype.Service;

@Service
public class StadiumService {

    private StadiumRepository stadiumRepository;

    public StadiumService(StadiumRepository stadiumRepository){
        this.stadiumRepository = stadiumRepository;
    }

}
