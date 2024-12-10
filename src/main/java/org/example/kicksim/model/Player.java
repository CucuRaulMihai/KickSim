package org.example.kicksim.model;

import org.springframework.context.annotation.Bean;

@Bean
public class Player {

    private String firstName;
    private String lastName;
    private Integer age;
    private Double skillLevel;
    private Double weight;
    private Double height;
    private POSITIONS position;
    private String nationality;

    public Player(String firstName, String lastName, Integer age, Double skillLevel, Double weight, Double height, POSITIONS position, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.skillLevel = skillLevel;
        this.weight = weight;
        this.height = height;
        this.position = position;
        this.nationality = nationality;
    }
}
