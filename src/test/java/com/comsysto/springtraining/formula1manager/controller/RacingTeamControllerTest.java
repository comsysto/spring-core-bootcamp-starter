package com.comsysto.springtraining.formula1manager.controller;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.comsysto.springtraining.formula1manager.model.RacingTeam;
import com.comsysto.springtraining.formula1manager.service.RacingTeamService;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class RacingTeamControllerTest {

    @MockBean
    private RacingTeamService racingTeamService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnRacingTeamFromService() throws Exception {
        when(racingTeamService.createRacingTeam(any())).thenReturn(new RacingTeam(UUID.randomUUID(), "Team 1"));
        this.mockMvc.perform(post("/api/racingteams/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Team 1\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString("Team 1")));
    }
}