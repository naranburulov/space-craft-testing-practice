package com.cydeo.spacecraft.service.impl;

import com.cydeo.spacecraft.dto.CreateGameDTO;
import com.cydeo.spacecraft.entity.Game;
import com.cydeo.spacecraft.entity.Player;
import com.cydeo.spacecraft.entity.Target;
import com.cydeo.spacecraft.enumtype.Boost;
import com.cydeo.spacecraft.enumtype.Level;
import com.cydeo.spacecraft.repository.GameRepository;
import com.cydeo.spacecraft.service.CreatePlayerService;
import com.cydeo.spacecraft.service.CreateTargetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateGameServiceImplTest {

    private CreateGameServiceImpl createGameService;

    @Mock
    private CreatePlayerService createPlayerService;
    @Mock
    private CreateTargetService createTargetService;
    @Mock
    private GameRepository gameRepository;

    @BeforeEach
    public void setUp(){
        createGameService = new CreateGameServiceImpl(createPlayerService, createTargetService,gameRepository);
    }

    @Test
    public void should_create_game_successfully(){
        //given
        CreateGameDTO createGameDTO = new CreateGameDTO();
        createGameDTO.setUsername("username");
        createGameDTO.setBoost(Boost.BIG_BOMB);
        createGameDTO.setLevel(Level.EASY);
        Player player = new Player();

        Set<Target> targetSet = new HashSet<>(){{
            add(new Target());
        }};

        Game game = new Game();
        game.setId(1L);
        //when
        when(createPlayerService.createPlayer(createGameDTO)).thenReturn(player);
        when(createTargetService.createTargets(createGameDTO.getLevel())).thenReturn(targetSet);
        when(gameRepository.save(any())).thenReturn(game);

        Long gameId = createGameService.createGame(createGameDTO);
        //then
        assertEquals(gameId, 1L);
    }
}