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
import com.eric.library.rest.domain.User;
import com.eric.library.rest.domain.CreatingUserData;

@Controller
@RequestMapping("/courses")
public class UserCommandsController {

    private static Logger LOGGER = LoggerFactory.getLogger(UserCommandsController.class);

    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> createCourse(@RequestBody CreatingUserData course, UriComponentsBuilder builder) {
        LOGGER.info("creating course with title: ", course.getTitle());
        DetailedCourseCreatedEvent courseCreated = courseService.createDetailedCourse(new CreateCourseEvent(course));

        User newCourse = User.fromDetailedCourse(courseCreated.getDetailedCourse());
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<User>(newCourse, headers, HttpStatus.CREATED);
    }

}
