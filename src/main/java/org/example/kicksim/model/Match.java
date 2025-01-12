package org.example.kicksim.model;

import java.util.List;
import java.util.Map;

public class Match {

    private Long id;
    private Team Team1;
    private Team Team2;
    private MatchDurations duration;
    private Map<Team, Integer> score;

    public Match(Team Team1, Team Team2, MatchDurations duration, Map<Team, Integer> score ) {
        this.Team1 = Team1;
        this.Team2 = Team2;
        this.duration = duration;
        this.score = score;
    }

    public Team getTeam1() {
        return Team1;
    }

    public void setTeam1(Team team1) {
        Team1 = team1;
    }

    public Team getTeam2() {
        return Team2;
    }

    public void setTeam2(Team team2) {
        Team2 = team2;
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
