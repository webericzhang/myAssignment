package com.eric.library.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.eric.library.core.service.UserService;
import com.eric.library.rest.domain.User;

@Controller
@RequestMapping("/courses")
public class UserQueriesController {

    private static Logger LOGGER = LoggerFactory.getLogger(UserQueriesController.class);

    @Autowired
    private UserService courseService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<User> getAllCourses() {
        LOGGER.info("all courses will be returned");
        return courseService.requestAllCourses().getCourses();
    }

}
