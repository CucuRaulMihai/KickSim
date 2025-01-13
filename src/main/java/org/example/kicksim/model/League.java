package org.example.kicksim.model;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Entity
@Table(name = "leagues")
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany
    @JoinColumn(name = "league_id", nullable = false)
    private List<Team> teams;

    @OneToMany
    @JoinColumn(name = "league_id", nullable = false)
    private List<Match> matches;

    @OneToMany
    @JoinTable(
            name = "league_standings",
            joinColumns = @JoinColumn(name = "league_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private List<Team> standings;


    public League(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public List<Team> getStandings() {
        return standings;
    }

    public void setStandings(List<Team> standings) {
        this.standings = standings;
    }
}
