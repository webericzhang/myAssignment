package com.eric.library.core.event;

import com.eric.library.rest.domain.CreatingUserData;

public class CreateUserEvent {

    private final CreatingUserData course;
    
    public CreateUserEvent(CreatingUserData course) {
        this.course = course;
    }
    
    public CreatingUserData getCourseData() {
        return course;
    }

}
