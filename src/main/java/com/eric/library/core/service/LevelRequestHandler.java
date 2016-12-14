package com.eric.library.core.service;

import java.util.ArrayList;
import java.util.List;

import com.eric.library.core.domain.UserLevel;
import com.eric.library.core.event.AllUserLevelsEvent;
import com.eric.library.rest.domain.Level;

public class LevelRequestHandler implements LevelService {

	public AllUserLevelsEvent requestAllCourseLevels() {
	    List<Level> levels = new ArrayList<Level>(UserLevel.values().length);
        
        for(UserLevel level : UserLevel.values()) {
            levels.add(Level.fromCourseLevel(level));
        }
        
		return new AllUserLevelsEvent(levels);
	}

}
