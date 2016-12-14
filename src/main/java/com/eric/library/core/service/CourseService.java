package com.eric.library.core.service;

import com.eric.library.core.event.AllCoursesEvent;
import com.eric.library.core.event.CreateCourseEvent;
import com.eric.library.core.event.DetailedCourseCreatedEvent;

public interface CourseService {

    public AllCoursesEvent requestAllCourses();

    public DetailedCourseCreatedEvent createDetailedCourse(CreateCourseEvent event);
}
