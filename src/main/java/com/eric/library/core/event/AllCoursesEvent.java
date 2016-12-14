package com.eric.library.core.event;

import java.util.List;

import com.eric.library.rest.domain.Course;

public class AllCoursesEvent {

    private final List<Course> courses;

    public AllCoursesEvent(List<Course> courses) {
        super();
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

}
