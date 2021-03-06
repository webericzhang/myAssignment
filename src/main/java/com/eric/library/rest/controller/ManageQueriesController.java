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

import com.eric.library.core.service.ManageService;
import com.eric.library.rest.domain.Management;

@Controller
@RequestMapping("/teachers")
public class ManageQueriesController {

    private static Logger LOGGER = LoggerFactory.getLogger(ManageQueriesController.class);

    @Autowired
    private ManageService teacherService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Management> getAllTeachers() {
        LOGGER.info("all teachers will be returned");
        return teacherService.requestAllTeachers().getTeachers();
    }

}
