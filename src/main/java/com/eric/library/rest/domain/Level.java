package com.eric.library.rest.domain;

import com.eric.library.core.domain.UserLevel;

public class Level {

    private String level;
    
    public String getLevel() {
        return level;
    }
    
    public static Level fromCourseLevel(UserLevel courseLevel) {
        Level level = new Level();

        level.level = courseLevel.toString();

        return level;
    }

}
