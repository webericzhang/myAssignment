package com.eric.library.core.event;

import java.util.List;

import com.eric.library.rest.domain.Level;

public class AllUserLevelsEvent {

    private final List<Level> levels;

    public AllUserLevelsEvent(List<Level> levels) {
        super();
        this.levels = levels;
    }

    public List<Level> getCourseLevels() {
        return levels;
    }

}
