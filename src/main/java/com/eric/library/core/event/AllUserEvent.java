package com.eric.library.core.event;

import java.util.List;

import com.eric.library.rest.domain.User;

public class AllUserEvent {

    private final List<User> courses;

    public AllUserEvent(List<User> courses) {
        super();
        this.courses = courses;
    }

    public List<User> getCourses() {
        return courses;
    }

}
