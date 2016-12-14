package com.eric.library.core.service;

import static com.eric.library.rest.controller.fixture.RESTDataFixture.createDetailedCourse;
import static com.eric.library.rest.controller.fixture.RESTDataFixture.createDetailedCourseEvent;
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

import com.eric.library.core.domain.DetailedCourse;
import com.eric.library.core.event.DetailedCourseCreatedEvent;
import com.eric.library.core.persistence.LibraryRepository;
import com.eric.library.core.service.CourseRequestsHandler;

public class CourseRequestsHandlerTest {

    @InjectMocks
    private CourseRequestsHandler handler;
    @Mock
    private LibraryRepository repository;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testRequestAllCoursesUsesRepository() {
        handler.requestAllCourses();
        
        verify(repository).listDetailedCourses();
    }
    
    @Test
    public void testCreateCourseUsesRepository() {
        long idCourse = 12345;
        long idTeacher = 112233;
        
        when(repository.saveDetailedCourse(any(DetailedCourse.class)))
            .thenReturn(createDetailedCourse(idCourse));
        
        DetailedCourseCreatedEvent event = 
                handler.createDetailedCourse(createDetailedCourseEvent(idTeacher));
        
        DetailedCourse created = event.getDetailedCourse();
        assertEquals(12345, created.getIdCourse());
        
        verify(repository, times(1)).findTeacher(idTeacher);
        verify(repository, times(1)).saveDetailedCourse(any(DetailedCourse.class));
    }

}
