package com.eric.library.rest.controller;

import static com.eric.library.rest.controller.fixture.RESTDataFixture.allCourses;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.eric.library.core.service.UserService;
import com.eric.library.rest.controller.UserQueriesController;

public class UserQueriesControllerTest {

    @InjectMocks
    UserQueriesController controller;

    @Mock
    UserService courseService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllCoursesUsesCourseService() throws Exception {
        when(courseService.requestAllCourses()).thenReturn(allCourses());

        controller.getAllCourses();

        verify(courseService, times(1)).requestAllCourses();
    }

}
