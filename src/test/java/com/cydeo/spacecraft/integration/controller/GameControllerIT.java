package com.cydeo.spacecraft.integration.controller;

import com.cydeo.spacecraft.entity.Game;
import com.cydeo.spacecraft.enumtype.Boost;
import com.cydeo.spacecraft.enumtype.Level;
import com.cydeo.spacecraft.model.request.CreateGameRequest;
import com.cydeo.spacecraft.model.response.CreateGameResponse;
import com.cydeo.spacecraft.repository.GameRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class GameControllerIT{
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private GameRepository gameRepository;

    @Test
    public void should_create_game_successfully() throws Exception {
        CreateGameRequest createGameRequest = new CreateGameRequest();
        createGameRequest.setUsername("username");
        createGameRequest.setBoost(Boost.BIG_BOMB);
        createGameRequest.setLevel(Level.EASY);

        // make a http request to specific
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/game/createGame")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createGameRequest)))
                // assertions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.gameId").exists())
                .andExpect(jsonPath("$.responseMessage").value("SUCCESS")).andReturn();

        String json = result.getResponse().getContentAsString();
        System.out.println(json);
        CreateGameResponse createGameResponse = objectMapper.readValue(json, CreateGameResponse.class);

        Game game = gameRepository.findById(createGameResponse.getGameId()).orElseThrow();
        assertEquals(game.getIsEnded(), false);
        assertEquals(game.getBoost(), createGameRequest.getBoost());
        assertEquals(game.getLevel(), createGameRequest.getLevel());
    }
}