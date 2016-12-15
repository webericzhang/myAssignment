package com.eric.library.core.service;

import static com.eric.library.rest.controller.fixture.RESTDataFixture.createDetailedUser;
import static com.eric.library.rest.controller.fixture.RESTDataFixture.createDetailedUserEvent;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.eric.library.core.domain.DetailedUser;
import com.eric.library.core.event.DetailedUserCreatedEvent;
import com.eric.library.core.persistence.LibraryRepository;
import com.eric.library.core.service.UserRequestsHandler;

public class UserRequestsHandlerTest {

    @InjectMocks
    private UserRequestsHandler handler;
    @Mock
    private LibraryRepository repository;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testRequestAllCoursesUsesRepository() {
        handler.requestAllCourses();
        
        verify(repository).listDetailedUsers();
    }
    
    @Test
    public void testCreateCourseUsesRepository() {
        long idCourse = 12345;
        long idTeacher = 112233;
        
        when(repository.saveDetailedUser(any(DetailedUser.class)))
            .thenReturn(createDetailedUser(idCourse));
        
        DetailedUserCreatedEvent event = 
                handler.createDetailedUser(createDetailedUserEvent(idTeacher));
        
        DetailedUser created = event.getDetailedUser();
        assertEquals(12345, created.getIdCourse());
        
        verify(repository, times(1)).findTeacher(idTeacher);
        verify(repository, times(1)).saveDetailedUser(any(DetailedUser.class));
    }

}
