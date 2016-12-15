package com.eric.library.core.persistence;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.eric.library.core.domain.DetailedUser;
import com.eric.library.core.persistence.UserMapper;
import com.eric.library.core.persistence.LibraryHSQLRepository;
import com.eric.library.core.persistence.ManageMapper;

public class LibraryHSQLRepositoryTest {

    @InjectMocks
    private LibraryHSQLRepository repository;
    @Mock
    private UserMapper courseMapper;
    @Mock
    private ManageMapper manageMapper;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testListCoursesUsesUserMapper() {
        repository.listDetailedUsers();
        verify(courseMapper).listActiveCourses();
    }
    
    @Test
    public void testSaveCourseUsesUserMapper() {
        DetailedUser dc = new DetailedUser();
        repository.saveDetailedUser(dc);
        verify(courseMapper).save(any(DetailedUser.class));
    }
    
    @Test
    public void testListTeachersUsesTeacherMapper() {
        repository.listTeachers();
        verify(manageMapper).list();
    }
    
    @Test
    public void testFindTeacherByIdUsesTeacherMapper()  {
        repository.findTeacher(12345);
        verify(manageMapper).findById(12345);
    }

}
