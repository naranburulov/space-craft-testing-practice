package com.cydeo.spacecraft.unit.service;

import com.cydeo.spacecraft.dto.CreateGameDTO;
import com.cydeo.spacecraft.entity.Player;
import com.cydeo.spacecraft.enumtype.Boost;
import com.cydeo.spacecraft.enumtype.Level;
import com.cydeo.spacecraft.service.impl.CreatePlayerServiceImpl;
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

    @Test
    public void should_create_player_with_super_ammo_boost_type_and_level_easy(){

        //given
        CreateGameDTO createGameDTO = new CreateGameDTO();
        createGameDTO.setBoost(Boost.SUPER_AMMO);
        createGameDTO.setLevel(Level.EASY);
        createGameDTO.setUsername("username");

        //when
        Player player = createPlayerService.createPlayer(createGameDTO);

        //then
        assertEquals(player.getHealth(), 2000);
        assertEquals(player.getArmor(), 7);
        assertEquals(player.getShootPower(), 160);

    }

    @Test
    public void should_throw_exception_when_boost_type_is_high_speed(){

        //given
        CreateGameDTO createGameDTO = new CreateGameDTO();
        createGameDTO.setBoost(Boost.HIGH_SPEED);
        createGameDTO.setLevel(Level.EASY);
        createGameDTO.setUsername("username");

        //then
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () ->{
                    createPlayerService.createPlayer(createGameDTO);
                });
        assertEquals(runtimeException.getMessage(),"Boost type must be valid");
    }


}