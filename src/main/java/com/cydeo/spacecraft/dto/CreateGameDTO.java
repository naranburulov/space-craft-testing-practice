package com.cydeo.spacecraft.dto;

import com.cydeo.spacecraft.enumtype.Boost;
import com.cydeo.spacecraft.enumtype.Level;
import lombok.Data;

@Data
public class CreateGameDTO {
    private String username;
    private Level level;
    private Boost boost;
}
