package com.eric.library.core.event;

import com.eric.library.core.domain.DetailedUser;

public class DetailedCourseCreatedEvent {

    private final DetailedUser detailedCourse;
    
    public DetailedCourseCreatedEvent(DetailedUser detailedCourse) {
        this.detailedCourse = detailedCourse;
    }
    
    public DetailedUser getDetailedCourse() {
        return detailedCourse;
    }

}
