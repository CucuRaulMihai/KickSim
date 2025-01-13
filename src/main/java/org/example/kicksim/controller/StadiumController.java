package org.example.kicksim.controller;


import org.example.kicksim.service.StadiumService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/stadiums")
@RestController
public class StadiumController {

    private StadiumService stadiumService;

    public StadiumController(StadiumService stadiumService){
        this.stadiumService = stadiumService;
    }

}
