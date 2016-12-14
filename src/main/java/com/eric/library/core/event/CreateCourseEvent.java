package com.eric.library.core.event;

import com.eric.library.rest.domain.CreatingUserData;

public class CreateCourseEvent {

    private final CreatingUserData course;
    
    public CreateCourseEvent(CreatingUserData course) {
        this.course = course;
    }
    
    public CreatingUserData getCourseData() {
        return course;
    }

}
