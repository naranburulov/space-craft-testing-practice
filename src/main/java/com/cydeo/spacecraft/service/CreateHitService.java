package com.cydeo.spacecraft.service;

import com.cydeo.spacecraft.dto.CreateHitDTO;
import com.cydeo.spacecraft.entity.Game;

public interface CreateHitService {
    Game createHit(CreateHitDTO createHitDTO);
}
