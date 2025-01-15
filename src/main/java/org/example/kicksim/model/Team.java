package org.example.kicksim.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "teams")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Team name is required")
    @Size(max = 100, min = 3, message = "The team name must be between 3 and 100 characters")
    @Column(name = "team_name", nullable = false)
    private String teamName;

    @NotNull(message = "Team nationality is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "team_nationality", nullable = false)
    private Countries teamNationality;

    @NotNull(message = "Year founded is required")
    @Min(value = 1800, message = "Year founded must be no earlier than 1800")
    @Max(value = 2025, message = "Year founded must be no later than 2025")
    @Column(name = "year_founded", nullable = false)
    private Integer yearFounded;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> teamPlayers;

    @ManyToMany(mappedBy = "teams")
    private List<Coach> coaches;

    @OneToOne(mappedBy = "homeTeam", cascade = CascadeType.ALL, orphanRemoval = true, optional = true)
    private Stadium stadium;

    @ManyToOne
    @JoinColumn(name = "league_id", nullable = false)
    @JsonIgnore
    private League league;


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

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
}
