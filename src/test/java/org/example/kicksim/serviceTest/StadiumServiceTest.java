package org.example.kicksim.serviceTest;

import org.example.kicksim.controller.StadiumController;
import org.example.kicksim.model.Stadium;
import org.example.kicksim.repository.StadiumRepository;
import org.example.kicksim.service.StadiumService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class StadiumServiceTest {

    @Mock
    private StadiumRepository stadiumRepository;

    @InjectMocks
    private StadiumService stadiumService;

    @Test
    public void testSaveStadium() {
        // Arrange
        Stadium stadium = new Stadium();
        stadium.setName("Camp Nou");
        stadium.setLocation("Barcelona");
        stadium.setCapacity(99354);

        Stadium savedStadium = new Stadium();
        savedStadium.setId(1L);
        savedStadium.setName("Camp Nou");
        savedStadium.setLocation("Barcelona");
        savedStadium.setCapacity(99354);

        when(stadiumRepository.save(stadium)).thenReturn(savedStadium);

        // Act
        Stadium result = stadiumService.save(stadium);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Camp Nou", result.getName());
        assertEquals("Barcelona", result.getLocation());
        assertEquals(99354, result.getCapacity());
        verify(stadiumRepository, times(1)).save(stadium);
    }

    @Test
    public void testFindById() {
        // Arrange
        Stadium stadium = new Stadium();
        stadium.setId(1L);
        stadium.setName("Camp Nou");
        stadium.setLocation("Barcelona");
        stadium.setCapacity(99354);

        when(stadiumRepository.findById(1L)).thenReturn(Optional.of(stadium));

        // Act
        Stadium result = stadiumService.findById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Camp Nou", result.getName());
        verify(stadiumRepository, times(1)).findById(1L);
    }

    @Test
    public void testFindAllStadiums() {
        // Arrange
        Stadium stadium = new Stadium();
        stadium.setId(1L);
        stadium.setName("Camp Nou");
        stadium.setLocation("Barcelona");
        stadium.setCapacity(99354);

        when(stadiumRepository.findAll()).thenReturn(Collections.singletonList(stadium));

        // Act
        List<Stadium> result = stadiumService.findAll();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Camp Nou", result.get(0).getName());
        verify(stadiumRepository, times(1)).findAll();
    }

}
