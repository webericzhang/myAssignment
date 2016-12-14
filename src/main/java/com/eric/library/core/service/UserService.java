package com.eric.library.core.service;

import com.eric.library.core.event.AllUserEvent;
import com.eric.library.core.event.CreateUserEvent;
import com.eric.library.core.event.DetailedUserCreatedEvent;

public interface UserService {

    public AllUserEvent requestAllCourses();

    public DetailedUserCreatedEvent createDetailedCourse(CreateUserEvent event);
}
