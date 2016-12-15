package com.eric.library.core.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.eric.library.core.domain.UserLevel;
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
        List<Level> levels = handler.requestAllUserLevels().getCourseLevels();
        
        assertEquals(UserLevel.BASIC.toString(), levels.get(0).getLevel());
        assertEquals(UserLevel.INTERMEDIATE.toString(), levels.get(1).getLevel());
        assertEquals(UserLevel.ADVANCED.toString(), levels.get(2).getLevel());
    }
    
}
