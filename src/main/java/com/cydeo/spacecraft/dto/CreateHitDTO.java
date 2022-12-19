package com.cydeo.spacecraft.dto;

import com.cydeo.spacecraft.enumtype.AttackType;
import lombok.Data;

@Data
public class CreateHitDTO {
    private AttackType attackType;
    private Long gameId;
}
