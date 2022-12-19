package com.cydeo.spacecraft.service;

import com.cydeo.spacecraft.dto.CreateGameDTO;
import com.cydeo.spacecraft.entity.Player;

public interface CreatePlayerService {
    Player createPlayer(CreateGameDTO createGameDTO);
}
