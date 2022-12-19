package com.cydeo.spacecraft.model.request;

import com.cydeo.spacecraft.enumtype.AttackType;
import lombok.Data;

@Data
public class CreateHitRequest {
    private AttackType attackType;
    private Long gameId;
}
