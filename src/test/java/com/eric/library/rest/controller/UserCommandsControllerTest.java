package com.eric.library.rest.controller;

import static com.eric.library.rest.controller.fixture.RESTDataFixture.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.eric.library.core.event.CreateUserEvent;
import com.eric.library.core.service.UserService;
import com.eric.library.rest.controller.UserCommandsController;
import com.eric.library.rest.domain.User;
import com.eric.library.rest.domain.CreatingUserData;

public class UserCommandsControllerTest {

    @InjectMocks
    private UserCommandsController controller;

    @Mock
    private UserService courseService;

    @Mock
    private CreatingUserData course;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllCoursesUsesCourseService() throws Exception {
        when(courseService.createDetailedUser(any(CreateUserEvent.class)))
            .thenReturn(courseCreated(12345));

        ResponseEntity<User> response = controller.createCourse(course, null);

        verify(courseService, times(1)).createDetailedUser(any(CreateUserEvent.class));
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

}
