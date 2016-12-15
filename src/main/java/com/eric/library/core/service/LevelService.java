package com.eric.library.core.service;

import com.eric.library.core.event.AllUserLevelsEvent;

public interface LevelService {

    public AllUserLevelsEvent requestAllUserLevels();
}
