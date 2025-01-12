package org.example.kicksim.model;

import java.util.List;

public class Team {

    private Long id;
    private String teamName;
    private Countries teamNationality;
    private Integer yearFounded;
    private List<Player> teamPlayers;


    public Team(Long id, String teamName, Countries teamNationality, Integer yearFounded, List<Player> teamPlayers) {
        this.id = id;
        this.teamName = teamName;
        this.teamNationality = teamNationality;
        this.yearFounded = yearFounded;
        this.teamPlayers = teamPlayers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Countries getTeamNationality() {
        return teamNationality;
    }

    public void setTeamNationality(Countries teamNationality) {
        this.teamNationality = teamNationality;
    }

    public Integer getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(Integer yearFounded) {
        this.yearFounded = yearFounded;
    }

    public List<Player> getTeamPlayers() {
        return teamPlayers;
    }

    public void setTeamPlayers(List<Player> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }
}
