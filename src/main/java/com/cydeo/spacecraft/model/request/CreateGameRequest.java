package com.cydeo.spacecraft.model.request;

import com.cydeo.spacecraft.enumtype.Boost;
import com.cydeo.spacecraft.enumtype.Level;
import lombok.Data;

@Data
public class CreateGameRequest {
    private String username;
    private Level level;
    private Boost boost;
}
