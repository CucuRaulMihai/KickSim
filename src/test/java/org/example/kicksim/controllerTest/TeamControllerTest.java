package org.example.kicksim.controllerTest;

import org.example.kicksim.controller.TeamController;
import org.example.kicksim.model.Countries;
import org.example.kicksim.model.Team;
import org.example.kicksim.service.TeamService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@ExtendWith(MockitoExtension.class)
@WebMvcTest(TeamController.class)
public class TeamControllerTest {

    @MockBean
    private TeamService teamService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateTeam() throws Exception {
        // Arrange: Create a mock Team object
        Team team = new Team();
        team.setId(1L);
        team.setTeamName("Manchester United");
        team.setTeamNationality(Countries.UNITED_KINGDOM);
        team.setYearFounded(1878);

        // Mock the behavior of the service layer
        when(teamService.save(Mockito.any(Team.class))).thenReturn(team);

        // Act: Perform the POST request and Assert the response
        mockMvc.perform(post("/teams")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"teamName\":\"Manchester United\",\"teamNationality\":\"UNITED_KINGDOM\",\"yearFounded\":1878}"))
                .andExpect(status().isCreated()) // Verify HTTP status is 201 Created
                .andExpect(content().contentType("application/json")) // Ensure the response type is JSON
                .andExpect(jsonPath("$.id").value(1)) // Verify the ID in the response
                .andExpect(jsonPath("$.teamName").value("Manchester United")) // Verify the team name
                .andExpect(jsonPath("$.teamNationality").value("UNITED_KINGDOM")) // Verify the nationality
                .andExpect(jsonPath("$.yearFounded").value(1878)); // Verify the year founded
    }

    @Test
    public void testGetTeamById() throws Exception {
        Team team = new Team();
        team.setId(1L);
        team.setTeamName("Manchester United");
        team.setTeamNationality(Countries.UNITED_KINGDOM);
        team.setYearFounded(1878);

        Mockito.when(teamService.findById(1L)).thenReturn(team);

        mockMvc.perform(get("/teams/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.teamName").value("Manchester United"))
                .andExpect(jsonPath("$.teamNationality").value("UNITED_KINGDOM"))
                .andExpect(jsonPath("$.yearFounded").value(1878));
    }

    @Test
    public void testGetAllTeams() throws Exception {
        Team team = new Team();
        team.setId(1L);
        team.setTeamName("Manchester United");
        team.setTeamNationality(Countries.UNITED_KINGDOM);
        team.setYearFounded(1878);

        Mockito.when(teamService.findAll()).thenReturn(Collections.singletonList(team));

        mockMvc.perform(get("/teams")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].teamName").value("Manchester United"))
                .andExpect(jsonPath("$[0].teamNationality").value("UNITED_KINGDOM"))
                .andExpect(jsonPath("$[0].yearFounded").value(1878));
    }

    @Test
    public void testDeleteTeam() throws Exception {
        Mockito.doNothing().when(teamService).deleteById(1L);

        mockMvc.perform(delete("/teams/1"))
                .andExpect(status().isNoContent());
    }
}
