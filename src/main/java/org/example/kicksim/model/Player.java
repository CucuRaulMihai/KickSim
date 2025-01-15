package org.example.kicksim.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Integer age;

    @NotNull(message = "The player skillLevel must not be null.")
    @Min(value = 1, message = "Skill Level must be at least 1.")
    @Max(value = 100, message = "Skill Level must be between 1 - 100.")
    @Column(name = "skill_level", nullable = false)
    private Double skillLevel;

    @Column(nullable = false)
    private Double weight;

    @Column(nullable = false)
    private Double height;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PlayerPositions position;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Countries nationality;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = true)
    @JsonSerialize(using = TeamSerializer.class)
    private Team team;

    public Player(){
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId(){
        return id;
    }

    public void setIt(Long id){
        this.id = id;
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
