package com.cydeo.spacecraft.service.impl;

import com.cydeo.spacecraft.dto.CreateGameDTO;
import com.cydeo.spacecraft.entity.Player;
import com.cydeo.spacecraft.enumtype.Boost;
import com.cydeo.spacecraft.enumtype.Level;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatePlayerServiceImplTest {

    private CreatePlayerServiceImpl createPlayerService;

    @BeforeEach
    public void setUp(){
        createPlayerService = new CreatePlayerServiceImpl();
    }


    @Test
    public void should_create_player_with_big_bomb_boost_type_and_level_easy(){

        //given
        CreateGameDTO createGameDTO = new CreateGameDTO();
        createGameDTO.setBoost(Boost.BIG_BOMB);
        createGameDTO.setLevel(Level.EASY);
        createGameDTO.setUsername("username");

        //when
        Player player = createPlayerService.createPlayer(createGameDTO);

        //then
        assertEquals(player.getHealth(), 2000);
        assertEquals(player.getArmor(), 7);
        assertEquals(player.getShootPower(), 5010);



    }

    @Test
    public void should_create_player_with_extra_shield_boost_type_and_level_easy(){

        //given
        CreateGameDTO createGameDTO = new CreateGameDTO();
        createGameDTO.setBoost(Boost.EXTRA_SHIELD);
        createGameDTO.setLevel(Level.EASY);
        createGameDTO.setUsername("username");

        //when
        Player player = createPlayerService.createPlayer(createGameDTO);

        //then
        assertEquals(player.getHealth(), 4145);
        assertEquals(player.getArmor(), 242);
        assertEquals(player.getShootPower(), 10);

    }

}