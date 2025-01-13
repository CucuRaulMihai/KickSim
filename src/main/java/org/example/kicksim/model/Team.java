package org.example.kicksim.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "team_name", nullable = false)
    private String teamName;

    @Enumerated(EnumType.STRING)
    @Column(name = "team_nationality", nullable = false)
    private Countries teamNationality;

    @Column(name = "year_founded", nullable = false)
    private Integer yearFounded;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> teamPlayers;

    @ManyToMany(mappedBy = "teams")
    private Set<Coach> coaches;

    @OneToOne(mappedBy = "homeTeam", cascade = CascadeType.ALL, orphanRemoval = true, optional = true)
    private Stadium stadium;


    public Team(){
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

    public Set<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(Set<Coach> coaches) {
        this.coaches = coaches;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }
}
