package com.eric.library.rest.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static com.eric.library.rest.controller.fixture.RESTDataFixture.allLevels;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.eric.library.core.service.LevelService;
import com.eric.library.rest.controller.LevelQueriesController;

public class LevelQueriesControllerTest {

    @InjectMocks
    LevelQueriesController controller;

    @Mock
    LevelService levelService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllUserLevelsUsesLevelService() throws Exception {
        when(levelService.requestAllUserLevels()).thenReturn(allLevels());

        controller.getAllLevels();

        verify(levelService, times(1)).requestAllUserLevels();
    }

}
