package org.example.kicksim.service;


import org.example.kicksim.model.Stadium;
import org.example.kicksim.repository.StadiumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StadiumService {

    private StadiumRepository stadiumRepository;

    public StadiumService(StadiumRepository stadiumRepository){
        this.stadiumRepository = stadiumRepository;
    }

    public Stadium save(Stadium stadium) {
        return stadiumRepository.save(stadium);
    }

    public Stadium findById(Long id) {
        return stadiumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stadium not found with id: " + id));
    }

    public List<Stadium> findAll() {
        return stadiumRepository.findAll();
    }

    public void deleteById(Long id) {
        if (!stadiumRepository.existsById(id)) {
            throw new RuntimeException("Stadium not found with id: " + id);
        }
        stadiumRepository.deleteById(id);
    }

    public Stadium findByName(String name) {
        return stadiumRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Stadium not found with name: " + name));
    }
}
