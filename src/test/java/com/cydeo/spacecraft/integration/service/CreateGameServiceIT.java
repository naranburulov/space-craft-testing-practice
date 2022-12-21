package com.cydeo.spacecraft.integration.service;

import com.cydeo.spacecraft.dto.CreateGameDTO;
import com.cydeo.spacecraft.enumtype.Boost;
import com.cydeo.spacecraft.enumtype.Level;
import com.cydeo.spacecraft.service.CreateGameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CreateGameServiceIT {
    @Autowired
    private CreateGameService createGameService;

    @Test
    public void should_create_game_successfully(){
        //given
        CreateGameDTO createGameDTO = new CreateGameDTO();
        createGameDTO.setUsername("username");
        createGameDTO.setBoost(Boost.BIG_BOMB);
        createGameDTO.setLevel(Level.EASY);
        //when
        Long gameId = createGameService.createGame(createGameDTO);
        //then
        assertNotNull(gameId);
    }
}