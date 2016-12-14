package com.eric.library.config;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eric.library.config.CoreConfig;
import com.eric.library.core.event.AllCoursesEvent;
import com.eric.library.core.service.CourseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CoreConfig.class })
public class CoreConfigIntegrationTest {

    @Autowired
    CourseService courseService;

    @Test
    public void testRequestAllCourses() {
        AllCoursesEvent event = courseService.requestAllCourses();
        assertEquals(10, event.getCourses().size());
    }
}