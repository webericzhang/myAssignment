package com.eric.library.core.service;

import java.util.ArrayList;
import java.util.List;

import com.eric.library.core.domain.CourseLevel;
import com.eric.library.core.event.AllCourseLevelsEvent;
import com.eric.library.rest.domain.Level;

public class LevelRequestHandler implements LevelService {

	public AllCourseLevelsEvent requestAllCourseLevels() {
	    List<Level> levels = new ArrayList<Level>(CourseLevel.values().length);
        
        for(CourseLevel level : CourseLevel.values()) {
            levels.add(Level.fromCourseLevel(level));
        }
        
		return new AllCourseLevelsEvent(levels);
	}

}
