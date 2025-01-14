package org.example.kicksim.serviceTest;

import org.example.kicksim.controller.TeamController;
import org.example.kicksim.model.Countries;
import org.example.kicksim.model.Team;
import org.example.kicksim.repository.TeamRepository;
import org.example.kicksim.service.TeamService;
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
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TeamServiceTest {

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private TeamService teamService;

    @Test
    public void testSaveTeam() {
        Team team = new Team();
        team.setTeamName("Manchester United");
        team.setTeamNationality(Countries.UNITED_KINGDOM);
        team.setYearFounded(1878);

        when(teamRepository.save(team)).thenReturn(team);

        Team result = teamService.save(team);

        assertNotNull(result);
        assertEquals("Manchester United", result.getTeamName());
        assertEquals(Countries.UNITED_KINGDOM, result.getTeamNationality());
        assertEquals(1878, result.getYearFounded());
        verify(teamRepository, times(1)).save(team);
    }

    @Test
    public void testFindById() {
        Team team = new Team();
        team.setId(1L);
        team.setTeamName("Manchester United");

        when(teamRepository.findById(1L)).thenReturn(Optional.of(team));

        Team result = teamService.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Manchester United", result.getTeamName());
        verify(teamRepository, times(1)).findById(1L);
    }

    @Test
    public void testFindAllTeams() {
        Team team = new Team();
        team.setId(1L);
        team.setTeamName("Manchester United");

        when(teamRepository.findAll()).thenReturn(Collections.singletonList(team));

        List<Team> result = teamService.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Manchester United", result.get(0).getTeamName());
        verify(teamRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteTeamById() {
        doNothing().when(teamRepository).deleteById(1L);

        teamService.deleteById(1L);

        verify(teamRepository, times(1)).deleteById(1L);
    }
}
