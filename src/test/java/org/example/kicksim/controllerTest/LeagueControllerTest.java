package org.example.kicksim.controllerTest;

import org.example.kicksim.controller.LeagueController;
import org.example.kicksim.model.League;
import org.example.kicksim.service.LeagueService;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(LeagueController.class)
public class LeagueControllerTest {

    @MockBean
    private LeagueService leagueService;

    @Autowired
    private MockMvc mockMvc;


    // Test for @PostMapping (createLeague)
    @Test
    public void testCreateLeague() throws Exception {
        // Arrange
        League league = new League();
        league.setId(1L);
        league.setName("Premier League");

        when(leagueService.save(Mockito.any(League.class))).thenReturn(league);


        // Act & Assert
        mockMvc.perform(post("/leagues")
                        .contentType(MediaType.APPLICATION_JSON) // Use "application/json" explicitly
                        .content("{\"name\":\"Premier League\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json")) // Ensure JSON response
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Premier League"));
    }

    // Test for @GetMapping("/{id}") (getLeague)
    @Test
    public void testGetLeagueById() throws Exception {
        // Arrange
        League league = new League();
        league.setId(1L);
        league.setName("Premier League");

        Mockito.when(leagueService.findById(1L)).thenReturn(league);

        // Act & Assert
        mockMvc.perform(get("/leagues/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Premier League\"}"))
                .andExpect(status().isOk()) // HTTP 200 OK
                .andExpect(content().contentType("application/json")) // Ensure JSON response
                .andExpect(jsonPath("$.id").value(1)) // Verify ID
                .andExpect(jsonPath("$.name").value("Premier League")); // Verify name
    }

    // Test for @GetMapping (getAllLeagues)
    @Test
    public void testGetAllLeagues() throws Exception {
        // Arrange
        League league = new League();
        league.setId(1L);
        league.setName("Premier League");

        Mockito.when(leagueService.findAll()).thenReturn(Collections.singletonList(league));

        // Act & Assert
        mockMvc.perform(get("/leagues")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) // HTTP 200 OK
                .andExpect(content().contentType("application/json")) // Ensure JSON response
                .andExpect(jsonPath("$").isArray()) // Ensure response is an array
                .andExpect(jsonPath("$.length()").value(1)) // Array size is 1
                .andExpect(jsonPath("$[0].id").value(1)) // Verify ID
                .andExpect(jsonPath("$[0].name").value("Premier League")); // Verify name
    }

    // Test for @DeleteMapping("/{id}") (deleteLeague)
    @Test
    public void testDeleteLeague() throws Exception {
        // Arrange
        Mockito.doNothing().when(leagueService).deleteById(1L);

        // Act & Assert
        mockMvc.perform(delete("/leagues/1"))
                .andExpect(status().isNoContent()); // HTTP 204 No Content
    }
}
