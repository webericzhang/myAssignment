package com.eric.library.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eric.library.core.domain.CourseLevel;
import com.eric.library.core.domain.DetailedCourse;
import com.eric.library.core.domain.DetailedTeacher;
import com.eric.library.core.event.AllCoursesEvent;
import com.eric.library.core.event.CreateCourseEvent;
import com.eric.library.core.event.DetailedCourseCreatedEvent;
import com.eric.library.core.persistence.LibraryRepository;
import com.eric.library.rest.domain.Course;
import com.eric.library.rest.domain.CreatingCourseData;

public class CourseRequestsHandler implements CourseService {

    @Autowired
    private final LibraryRepository repository;
    
    public CourseRequestsHandler(LibraryRepository repository) {
        this.repository = repository;
    }
    
    public AllCoursesEvent requestAllCourses() {
        List<DetailedCourse> detailedCourses = repository.listDetailedCourses();
        List<Course> courses = new ArrayList<Course>(detailedCourses.size());
        
        for(DetailedCourse dc : detailedCourses) {
            courses.add(Course.fromDetailedCourse(dc));
        }
        
        return new AllCoursesEvent(courses);
    }

    public DetailedCourseCreatedEvent createDetailedCourse(CreateCourseEvent event) {
        CreatingCourseData courseData = event.getCourseData();
        DetailedTeacher teacher = repository.findTeacher(courseData.getTeacher());
        CourseLevel level = CourseLevel.valueOf(courseData.getLevel());
        
        DetailedCourse course = DetailedCourse.fromCreatingCourseData(courseData, teacher, level);
        DetailedCourse saved = repository.saveDetailedCourse(course);
        
        return new DetailedCourseCreatedEvent(saved);
    }

}
