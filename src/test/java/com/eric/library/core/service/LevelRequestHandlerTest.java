package com.eric.library.core.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.eric.library.core.domain.CourseLevel;
import com.eric.library.core.service.LevelRequestHandler;
import com.eric.library.rest.domain.Level;

public class LevelRequestHandlerTest {

    @InjectMocks
    private LevelRequestHandler handler;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testRequestAllLevelsReturnsAllEnumValues() {
        List<Level> levels = handler.requestAllCourseLevels().getCourseLevels();
        
        assertEquals(CourseLevel.BASIC.toString(), levels.get(0).getLevel());
        assertEquals(CourseLevel.INTERMEDIATE.toString(), levels.get(1).getLevel());
        assertEquals(CourseLevel.ADVANCED.toString(), levels.get(2).getLevel());
    }
    
}
