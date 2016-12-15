package com.eric.library.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eric.library.core.domain.UserLevel;
import com.eric.library.core.domain.DetailedUser;
import com.eric.library.core.domain.DetailedManage;
import com.eric.library.core.event.AllUserEvent;
import com.eric.library.core.event.CreateUserEvent;
import com.eric.library.core.event.DetailedUserCreatedEvent;
import com.eric.library.core.persistence.LibraryRepository;
import com.eric.library.rest.domain.User;
import com.eric.library.rest.domain.CreatingUserData;

public class UserRequestsHandler implements UserService {

    @Autowired
    private final LibraryRepository repository;
    
    public UserRequestsHandler(LibraryRepository repository) {
        this.repository = repository;
    }
    
    public AllUserEvent requestAllCourses() {
        List<DetailedUser> detailedCourses = repository.listDetailedUsers();
        List<User> courses = new ArrayList<User>(detailedCourses.size());
        
        for(DetailedUser dc : detailedCourses) {
            courses.add(User.fromDetailedUser(dc));
        }
        
        return new AllUserEvent(courses);
    }

    public DetailedUserCreatedEvent createDetailedUser(CreateUserEvent event) {
        CreatingUserData courseData = event.getCourseData();
        DetailedManage teacher = repository.findTeacher(courseData.getTeacher());
        UserLevel level = UserLevel.valueOf(courseData.getLevel());
        
        DetailedUser course = DetailedUser.fromCreatingCourseData(courseData, teacher, level);
        DetailedUser saved = repository.saveDetailedUser(course);
        
        return new DetailedUserCreatedEvent(saved);
    }

}
