package com.eric.library.config;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eric.library.core.event.AllUserEvent;
import com.eric.library.core.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CoreConfig.class })
public class CoreConfigIntegrationTest {

    @Autowired
    UserService courseService;

    @Test
    public void testRequestAllCourses() {
        AllUserEvent event = courseService.requestAllCourses();
        assertEquals(10, event.getCourses().size());
    }
}