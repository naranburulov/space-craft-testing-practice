package com.cydeo.spacecraft.service;

import com.cydeo.spacecraft.entity.Target;
import com.cydeo.spacecraft.enumtype.Level;

import java.util.Set;

public interface CreateTargetService {
    Set<Target> createTargets(Level level);
}
