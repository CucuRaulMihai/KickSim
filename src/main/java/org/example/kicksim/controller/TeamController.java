package org.example.kicksim.controller;


import org.example.kicksim.service.TeamService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/team")
@RestController
public class TeamController {

    private TeamService teamService;

    public TeamController(TeamService teamService){
        this.teamService = teamService;
    }
}
