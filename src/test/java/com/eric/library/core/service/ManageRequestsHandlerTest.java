package com.eric.library.core.service;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.InjectMocks;

import com.eric.library.core.persistence.LibraryRepository;
import com.eric.library.core.service.ManageRequestsHandler;

public class ManageRequestsHandlerTest {

    @InjectMocks
    private ManageRequestsHandler handler;
    @Mock
    private LibraryRepository repository;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testRequestAllTeachersUsesRepository() {
        handler.requestAllTeachers();
        
        verify(repository).listTeachers();
    }

}
