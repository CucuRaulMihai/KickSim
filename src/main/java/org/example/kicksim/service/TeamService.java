package org.example.kicksim.service;


import org.example.kicksim.model.Team;
import org.example.kicksim.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    public Team save(Team team) {
        return teamRepository.save(team);
    }

    public Team findById(Long id) {
        return teamRepository.findById(id).orElse(null);
    }

    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    public Team findByTeamName(String teamName) {
        return teamRepository.findByTeamName(teamName)
                .orElseThrow(() -> new RuntimeException("Team not found with name: " + teamName));
    }

    public void deleteById(Long id) {
        teamRepository.deleteById(id);
    }
}
