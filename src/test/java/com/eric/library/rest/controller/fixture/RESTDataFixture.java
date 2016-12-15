package com.eric.library.rest.controller.fixture;

import java.util.ArrayList;
import java.util.List;

import com.eric.library.core.domain.UserLevel;
import com.eric.library.core.domain.DetailedUser;
import com.eric.library.core.domain.DetailedManage;
import com.eric.library.core.event.AllUserLevelsEvent;
import com.eric.library.core.event.AllUserEvent;
import com.eric.library.core.event.AllManageEvent;
import com.eric.library.core.event.CreateUserEvent;
import com.eric.library.core.event.DetailedUserCreatedEvent;
import com.eric.library.rest.domain.User;
import com.eric.library.rest.domain.CreatingUserData;
import com.eric.library.rest.domain.Level;
import com.eric.library.rest.domain.Management;

public class RESTDataFixture {

    public static AllUserEvent allCourses() {
        List<User> courses = new ArrayList<User>(3);
        
        courses.add(createCourse(1));
        courses.add(createCourse(3));
        courses.add(createCourse(5));
        
        return new AllUserEvent(courses);
    }

    public static DetailedUser createDetailedUser(long id) {
        DetailedUser course = new DetailedUser();
        
        course.setIdCourse(id);
        course.setTitle("Title " + id);
        course.setTeacher(createDetailedTeacher(id));
        course.setLevel(UserLevel.BASIC);
        course.setHoursLong(12.5f);
        course.setActive(true);
        
        return course;
    }

    public static User createCourse(long id) {
        return User.fromDetailedUser(createDetailedUser(id));
    }

    public static AllManageEvent allTeachers() {
        List<Management> teachers = new ArrayList<Management>(3);
        
        teachers.add(Management.fromTeacher(createDetailedTeacher(0)));
        teachers.add(Management.fromTeacher(createDetailedTeacher(1)));
        teachers.add(Management.fromTeacher(createDetailedTeacher(2)));
        
        return new AllManageEvent(teachers);
    }
    
    private static DetailedManage createDetailedTeacher(long id) {
        DetailedManage teacher = new DetailedManage();
        
        teacher.setIdTeacher(id);
        teacher.setName("Teacher " + id);
        
        return teacher;
    }

    public static AllUserLevelsEvent allLevels() {
        List<Level> levels = new ArrayList<Level>(UserLevel.values().length);
        
        for(UserLevel level : UserLevel.values()) {
            levels.add(Level.fromCourseLevel(level));
        }
        
        return new AllUserLevelsEvent(levels);
    }
    
    public static DetailedUserCreatedEvent courseCreated(long id) {
        return new DetailedUserCreatedEvent(createDetailedUser(id));
    }

    public static String standardCourseJSON(long id) {
        return "{ \"title\": \"Title " + id + "\" }";
    }
    
    public static CreateUserEvent createDetailedUserEvent(long idTeacher) {
        return new CreateUserEvent(createCreatingCourseData(idTeacher));
    }

    private static CreatingUserData createCreatingCourseData(long idTeacher) {
        CreatingUserData data = new CreatingUserData();
        
        data.setTitle("Title 1");
        data.setTeacher(idTeacher);
        data.setLevel("BASIC");
        data.setHoursLong(12.5f);
        data.setActive(true);
        
        return data;
    }
}
