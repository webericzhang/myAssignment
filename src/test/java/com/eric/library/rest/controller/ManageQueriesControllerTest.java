package com.eric.library.rest.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static com.eric.library.rest.controller.fixture.RESTDataFixture.allTeachers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.eric.library.core.service.ManageService;
import com.eric.library.rest.controller.ManageQueriesController;

public class ManageQueriesControllerTest {

    @InjectMocks
    ManageQueriesController controller;

    @Mock
    ManageService teacherService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllTeachersUsesTeacherService() throws Exception {
        when(teacherService.requestAllTeachers()).thenReturn(allTeachers());

        controller.getAllTeachers();

        verify(teacherService, times(1)).requestAllTeachers();
    }

}
