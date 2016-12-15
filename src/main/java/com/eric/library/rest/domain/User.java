package com.eric.library.rest.domain;

import com.eric.library.core.domain.UserLevel;
import com.eric.library.core.domain.DetailedUser;

public class User {

    private String title;
    private UserLevel level;
    private float hoursLong;
    
    public String getTitle() {
        return title;
    }
    public UserLevel getLevel() {
        return level;
    }
    public float getHoursLong() {
        return hoursLong;
    }
    
    public static User fromDetailedUser(DetailedUser detailedCourse) {
        User course = new User();
        
        course.title = detailedCourse.getTitle();
        course.level = detailedCourse.getLevel();
        course.hoursLong = detailedCourse.getHoursLong();
        
        return course;
    }

}
