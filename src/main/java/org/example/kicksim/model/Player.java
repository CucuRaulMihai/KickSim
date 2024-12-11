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
    private PlayerPositions position;
    private Countries nationality;

    public Player(String firstName, String lastName, Integer age, Double skillLevel, Double weight, Double height, PlayerPositions position, Countries nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.skillLevel = skillLevel;
        this.weight = weight;
        this.height = height;
        this.position = position;
        this.nationality = nationality;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(Double skillLevel) {
        this.skillLevel = skillLevel;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Countries getNationality() {
        return nationality;
    }

    public void setNationality(Countries nationality) {
        this.nationality = nationality;
    }

    public PlayerPositions getPosition() {
        return position;
    }

    public void setPosition(PlayerPositions position) {
        this.position = position;
    }
}
