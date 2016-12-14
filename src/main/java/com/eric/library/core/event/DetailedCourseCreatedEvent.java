package com.eric.library.core.event;

import com.eric.library.core.domain.DetailedCourse;

public class DetailedCourseCreatedEvent {

    private final DetailedCourse detailedCourse;
    
    public DetailedCourseCreatedEvent(DetailedCourse detailedCourse) {
        this.detailedCourse = detailedCourse;
    }
    
    public DetailedCourse getDetailedCourse() {
        return detailedCourse;
    }

}
