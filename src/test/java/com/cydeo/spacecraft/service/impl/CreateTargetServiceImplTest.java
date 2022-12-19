package com.cydeo.spacecraft.service.impl;

import com.cydeo.spacecraft.entity.Target;
import com.cydeo.spacecraft.enumtype.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateTargetServiceImplTest {

    private CreateTargetServiceImpl createTargetService;

    @BeforeEach
    public void setUp(){
        createTargetService = new CreateTargetServiceImpl();
    }

    @Test
    public void should_create_targets_with_easy_level(){
        // given
        Level level = Level.EASY;
        // when
        Set<Target> targets = createTargetService.createTargets(level);
        // then
        Target target = targets.stream().findAny().get();

        assertEquals(targets.size(), 1);
        assertEquals(target.getHealth(),233);
        assertEquals(target.getArmor(),7);
        assertEquals(target.getShootPower(),10);
    }
}