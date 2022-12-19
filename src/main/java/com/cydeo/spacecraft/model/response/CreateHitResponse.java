package com.cydeo.spacecraft.model.response;

import com.cydeo.spacecraft.entity.Player;
import com.cydeo.spacecraft.entity.Target;
import lombok.Data;

import java.util.Set;

@Data
public class CreateHitResponse {
    private String responseMessage;
    private Boolean isEnded = false;
    private Boolean isWin = false;
    private Player player;
    private Set<Target> targets;
    private Long gameId;
}
