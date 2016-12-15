package com.eric.library.rest.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;

import static com.eric.library.rest.controller.fixture.RESTDataFixture.courseCreated;
import static com.eric.library.rest.controller.fixture.RESTDataFixture.standardCourseJSON;
import com.eric.library.core.event.CreateUserEvent;
import com.eric.library.core.service.UserService;
import com.eric.library.rest.controller.UserCommandsController;

public class UserCommandsControllerIntegrationTest {

    private static final int COURSE_ID = 12345;

    MockMvc mockMvc;

    @InjectMocks
    UserCommandsController controller;

    @Mock
    UserService courseService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        this.mockMvc = standaloneSetup(controller)
                .setMessageConverters(new MappingJackson2HttpMessageConverter())
                .build();

        when(courseService.createDetailedUser(any(CreateUserEvent.class)))
                .thenReturn(courseCreated(COURSE_ID));
    }

    @Test
    public void thatCreateCourseUsesHttpCreated() throws Exception {
        this.mockMvc.perform(post("/courses")
                .content(standardCourseJSON(COURSE_ID))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void thatCreateCourseRendersAsJson() throws Exception {
        this.mockMvc.perform(post("/courses")
                .content(standardCourseJSON(COURSE_ID))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value("Title " + COURSE_ID));
    }

}