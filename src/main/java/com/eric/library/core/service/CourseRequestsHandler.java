package com.eric.library.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eric.library.core.domain.UserLevel;
import com.eric.library.core.domain.DetailedUser;
import com.eric.library.core.domain.DetailedManage;
import com.eric.library.core.event.AllCoursesEvent;
import com.eric.library.core.event.CreateCourseEvent;
import com.eric.library.core.event.DetailedCourseCreatedEvent;
import com.eric.library.core.persistence.LibraryRepository;
import com.eric.library.rest.domain.User;
import com.eric.library.rest.domain.CreatingUserData;

public class CourseRequestsHandler implements CourseService {

    @Autowired
    private final LibraryRepository repository;
    
    public CourseRequestsHandler(LibraryRepository repository) {
        this.repository = repository;
    }
    
    public AllCoursesEvent requestAllCourses() {
        List<DetailedUser> detailedCourses = repository.listDetailedCourses();
        List<User> courses = new ArrayList<User>(detailedCourses.size());
        
        for(DetailedUser dc : detailedCourses) {
            courses.add(User.fromDetailedCourse(dc));
        }
        
        return new AllCoursesEvent(courses);
    }

    public DetailedCourseCreatedEvent createDetailedCourse(CreateCourseEvent event) {
        CreatingUserData courseData = event.getCourseData();
        DetailedManage teacher = repository.findTeacher(courseData.getTeacher());
        UserLevel level = UserLevel.valueOf(courseData.getLevel());
        
        DetailedUser course = DetailedUser.fromCreatingCourseData(courseData, teacher, level);
        DetailedUser saved = repository.saveDetailedCourse(course);
        
        return new DetailedCourseCreatedEvent(saved);
    }

}
