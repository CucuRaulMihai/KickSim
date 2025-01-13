package org.example.kicksim.controller;


import org.example.kicksim.service.LeagueService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/league")
@RestController
public class LeagueController {

    private LeagueService leagueService;

    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }
}
