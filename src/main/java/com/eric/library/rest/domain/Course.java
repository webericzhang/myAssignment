package com.eric.library.rest.domain;

import com.eric.library.core.domain.CourseLevel;
import com.eric.library.core.domain.DetailedCourse;

public class Course {

    private String title;
    private CourseLevel level;
    private float hoursLong;
    
    public String getTitle() {
        return title;
    }
    public CourseLevel getLevel() {
        return level;
    }
    public float getHoursLong() {
        return hoursLong;
    }
    
    public static Course fromDetailedCourse(DetailedCourse detailedCourse) {
        Course course = new Course();
        
        course.title = detailedCourse.getTitle();
        course.level = detailedCourse.getLevel();
        course.hoursLong = detailedCourse.getHoursLong();
        
        return course;
    }

}
