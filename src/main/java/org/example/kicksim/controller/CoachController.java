package org.example.kicksim.controller;


import org.example.kicksim.service.CoachService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/coach")
@RestController
public class CoachController {

    private CoachService coachService;

    public CoachController(CoachService coachService){
        this.coachService = coachService;
    }
}
