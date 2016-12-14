package com.eric.library.core.event;

import com.eric.library.rest.domain.CreatingCourseData;

public class CreateCourseEvent {

    private final CreatingCourseData course;
    
    public CreateCourseEvent(CreatingCourseData course) {
        this.course = course;
    }
    
    public CreatingCourseData getCourseData() {
        return course;
    }

}
