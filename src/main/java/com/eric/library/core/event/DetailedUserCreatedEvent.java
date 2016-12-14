package com.eric.library.core.event;

import com.eric.library.core.domain.DetailedUser;

public class DetailedUserCreatedEvent {

    private final DetailedUser detailedCourse;
    
    public DetailedUserCreatedEvent(DetailedUser detailedCourse) {
        this.detailedCourse = detailedCourse;
    }
    
    public DetailedUser getDetailedCourse() {
        return detailedCourse;
    }

}
