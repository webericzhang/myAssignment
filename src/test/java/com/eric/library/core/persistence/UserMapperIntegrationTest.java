package com.eric.library.core.persistence;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eric.library.config.CoreConfig;
import com.eric.library.core.domain.UserLevel;
import com.eric.library.core.domain.DetailedUser;
import com.eric.library.core.persistence.UserMapper;
import com.eric.library.rest.controller.fixture.RESTDataFixture;
  
//@SuppressWarnings("restriction")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CoreConfig.class })  
public class UserMapperIntegrationTest {  

    @Resource  
    UserMapper courseMapper;  

    @Test
    public void testListAllCourses() {
        List<DetailedUser> courses = courseMapper.listActiveCourses();
        assertEquals("test-data.sql inserts 10 active courses, 5 inactive", 10, courses.size());
    }

    @Test
    public void testFirstCourseData() {
        DetailedUser course = courseMapper.findById(0);
        
        assertEquals(0, course.getIdCourse());
        assertEquals("Title 1", course.getTitle());
        assertEquals("Teacher 1", course.getTeacher().getName());
        assertEquals(UserLevel.BASIC, course.getLevel());
        assertEquals(12.5, course.getHoursLong(), 0.1);
        assertEquals(true, course.isActive());
    }

    @Test
    public void testIntermediateLevelCourse() {
        DetailedUser course = courseMapper.findById(2);
        assertEquals(UserLevel.INTERMEDIATE, course.getLevel());
    }

    @Test
    public void testAdvancedLevelCourse() {
        DetailedUser course = courseMapper.findById(5);
        assertEquals(UserLevel.ADVANCED, course.getLevel());
    }

    @Test
    public void testIntegersHoursLong() {
        DetailedUser course = courseMapper.findById(9);
        assertEquals(10.0, course.getHoursLong(), 0.1);
    }
    
    @Test
    public void testCourse13thHasTeacher4th() {
        DetailedUser course = courseMapper.findById(13);
        assertEquals("Teacher 4", course.getTeacher().getName());
    }
    
    @Test
    public void testSaveCourse() {
        DetailedUser course = RESTDataFixture.createDetailedUser(100);
        course.getTeacher().setIdTeacher(0);

        int oldNumberOfRecords = courseMapper.listActiveCourses().size();
        courseMapper.save(course);
        int newNumberOfRecords = courseMapper.listActiveCourses().size();
        
        assertEquals(newNumberOfRecords, oldNumberOfRecords + 1);
    }

}