package org.example.kicksim.controllerTest;

import org.example.kicksim.controller.StadiumController;
import org.example.kicksim.model.Stadium;
import org.example.kicksim.service.StadiumService;
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
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(StadiumController.class)
public class StadiumControllerTest {

    @MockBean
    private StadiumService stadiumService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllStadiums() throws Exception {
        // Create a mock Stadium object
        Stadium stadium = new Stadium();
        stadium.setId(1L);
        stadium.setName("Camp Nou");
        stadium.setLocation("Barcelona");
        stadium.setCapacity(99354);

        // Mock service behavior
        when(stadiumService.findAll()).thenReturn(Collections.singletonList(stadium));

        // Perform the GET request for all stadiums
        mockMvc.perform(get("/stadiums"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json")) // Ensure the response type is JSON
                .andExpect(jsonPath("$").isArray()) // Ensure the response is an array
                .andExpect(jsonPath("$.length()").value(1)) // Ensure the array has only one stadium
                .andExpect(jsonPath("$[0].id").value(1)) // Verify the ID of the stadium
                .andExpect(jsonPath("$[0].name").value("Camp Nou")) // Verify the name
                .andExpect(jsonPath("$[0].location").value("Barcelona")) // Verify the location
                .andExpect(jsonPath("$[0].capacity").value(99354)); // Verify the capacity
    }

    @Test
    public void testGetStadiumById() throws Exception {
        Stadium stadium = new Stadium();
        stadium.setId(1L);
        stadium.setName("Camp Nou");
        stadium.setLocation("Barcelona");
        stadium.setCapacity(99354);

        when(stadiumService.findById(1L)).thenReturn(stadium);

        mockMvc.perform(get("/stadiums/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Camp Nou"))
                .andExpect(jsonPath("$.location").value("Barcelona"))
                .andExpect(jsonPath("$.capacity").value(99354));
    }


    @Test
    public void testDeleteStadium() throws Exception {
        Mockito.doNothing().when(stadiumService).deleteById(1L);

        mockMvc.perform(delete("/stadiums/1"))
                .andExpect(status().isNoContent());
    }
}