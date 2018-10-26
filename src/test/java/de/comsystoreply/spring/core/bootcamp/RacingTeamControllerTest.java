package de.comsystoreply.spring.core.bootcamp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.comsystoreply.spring.core.bootcamp.data.model.RacingTeam;
import de.comsystoreply.spring.core.bootcamp.services.Racing;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        loader = AnnotationConfigWebContextLoader.class,
        classes = {ApplicationInitializer.class})
@WebAppConfiguration
@Transactional
public class RacingTeamControllerTest {

    @Autowired
    private WebApplicationContext applicationContext;

    @Autowired
    private Racing racingService;

    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mvc;
    @BeforeEach
    void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllRacingTeams() throws Exception {


        racingService.createRacingTeam("Banana");
        racingService.createRacingTeam("Tomato");

        MvcResult result = mvc.perform(
                get("/racingTeams").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect( status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        String json = result.getResponse().getContentAsString();
        List<RacingTeam> list = objectMapper.readValue(json, new TypeReference<List<RacingTeam>>() {
        });

        Assert.assertNotNull(list);
        Assert.assertFalse(list.isEmpty());

        List<String> listOfNames = list.stream().map(RacingTeam::getName).collect(Collectors.toList());
        Assert.assertTrue(listOfNames.contains("Banana"));
        Assert.assertTrue(listOfNames.contains("Tomato"));
    }

    @Test
    void createRacingTeam_ok() throws Exception {
        MvcResult result = mvc.perform(
                post("/racingTeams").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content("{\"name\":\"Banana\"}"))
                .andExpect( status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();
        Assert.assertEquals(1, racingService.getAllRacingTeams().size());
    }

    @Test
    void createRacingTeam_alreadyExists() throws Exception {
        racingService.createRacingTeam("Banana");

        MvcResult result = mvc.perform(
                post("/racingTeams").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content("{\"name\":\"Banana\"}"))
                .andExpect( status().isBadRequest())
                .andReturn();
    }

    @Test
    void deleteRacingTeamByName() throws Exception{
        racingService.createRacingTeam("Banana");
        mvc.perform(
                delete("/racingTeams/Banana").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect( status().isNoContent())
                .andReturn();
        Assert.assertTrue(racingService.getAllRacingTeams().isEmpty());
    }

    @Test
    void deleteAllRacingTeams() throws Exception{
        racingService.createRacingTeam("Banana");
        racingService.createRacingTeam("Carrot");
        mvc.perform(
                delete("/racingTeams").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect( status().isNoContent())
                .andReturn();
        Assert.assertTrue(racingService.getAllRacingTeams().isEmpty());
    }


    @Test
    void modifyTeamByName_ok() throws Exception {
        racingService.createRacingTeam("Carrot");

        MvcResult result = mvc.perform(
                put("/racingTeams/Carrot").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content("{\"name\":\"Banana\"}"))
                .andExpect( status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();
        Assert.assertEquals(1, racingService.getAllRacingTeams().size());
        Assert.assertTrue(racingService.getRacingTeamByName("Banana").isPresent());
    }

    @Test
    void modifyTeamByName_notFound() throws Exception {

        MvcResult result = mvc.perform(
                put("/racingTeams/Carrot").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content("{\"name\":\"Banana\"}"))
                .andExpect( status().isNotFound())
                .andReturn();
    }

}