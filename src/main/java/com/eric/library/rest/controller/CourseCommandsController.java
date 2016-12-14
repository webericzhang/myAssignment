package com.eric.library.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.eric.library.core.event.CreateCourseEvent;
import com.eric.library.core.event.DetailedCourseCreatedEvent;
import com.eric.library.core.service.CourseService;
import com.eric.library.rest.domain.Course;
import com.eric.library.rest.domain.CreatingCourseData;

@Controller
@RequestMapping("/courses")
public class CourseCommandsController {

    private static Logger LOGGER = LoggerFactory.getLogger(CourseCommandsController.class);

    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Course> createCourse(@RequestBody CreatingCourseData course, UriComponentsBuilder builder) {
        LOGGER.info("creating course with title: ", course.getTitle());
        DetailedCourseCreatedEvent courseCreated = courseService.createDetailedCourse(new CreateCourseEvent(course));

        Course newCourse = Course.fromDetailedCourse(courseCreated.getDetailedCourse());
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Course>(newCourse, headers, HttpStatus.CREATED);
    }

}
