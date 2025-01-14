package org.example.kicksim.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Map;


@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team1_id", nullable = false)
    private Team team1;

    @ManyToOne
    @JoinColumn(name = "team2_id", nullable = false)
    private Team team2;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MatchDurations duration;

    @Column(nullable = false)
    private Integer teamScore1;

    @Column(nullable = false)
    private Integer teamScore2;

    @ManyToOne
    //nu e necesar ca un meci sa aiba un stadion, pentru exemplu didactic
    @JoinColumn(name = "stadium_id", nullable = true)
    private Stadium matchStadium;

    public Match(){
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTeamScore1() {
        return teamScore1;
    }

    public void setTeamScore1(Integer teamScore1) {
        this.teamScore1 = teamScore1;
    }

    public Integer getTeamScore2() {
        return teamScore2;
    }

    public void setTeamScore2(Integer teamScore2) {
        this.teamScore2 = teamScore2;
    }

    public Stadium getMatchStadium() {
        return matchStadium;
    }

    public void setMatchStadium(Stadium matchStadium) {
        this.matchStadium = matchStadium;
    }

    public MatchDurations getDuration(){
        return duration;
    }

    void setDuration(MatchDurations duration){
        this.duration = duration;
    }



}
