package org.example.kicksim.controller;


import org.example.kicksim.service.MatchService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/match")
@RestController
public class MatchController {

    private MatchService matchService;

    public MatchController(MatchService matchService){
        this.matchService = matchService;
    }
}
