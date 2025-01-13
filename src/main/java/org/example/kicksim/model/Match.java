package org.example.kicksim.model;

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

    @ElementCollection
    @CollectionTable(name = "matches_scores", joinColumns = @JoinColumn(name = "match_id"))
    @MapKeyJoinColumn(name = "team_id")
    @Column(name = "score")
    private Map<Team, Integer> score;

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

    public Map<Team, Integer> getScore(){
        return score;
    }

    void setScore(Map<Team, Integer> score){
        this.score = score;
    }

    public MatchDurations getDuration(){
        return duration;
    }

    void setDuration(MatchDurations duration){
        this.duration = duration;
    }



}
