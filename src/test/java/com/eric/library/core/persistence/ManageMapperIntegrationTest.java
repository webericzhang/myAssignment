package com.eric.library.core.persistence;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eric.library.config.CoreConfig;
import com.eric.library.core.domain.DetailedManage;
import com.eric.library.core.persistence.ManageMapper;
  
//@SuppressWarnings("restriction")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CoreConfig.class })  
public class ManageMapperIntegrationTest {  
  
    @Resource  
    ManageMapper manageMapper;  
    
    @Test
    public void testListAllTeachers() {
        List<DetailedManage> teachers = manageMapper.list();
        assertEquals("test-data.sql insterts 5 teachers", 5, teachers.size());
    }  
    
    @Test
    public void testAllTeachersData() {
        List<DetailedManage> teachers = manageMapper.list();
        
        for(int i = 0; i < teachers.size(); i++) {
            DetailedManage teacher = teachers.get(i);
            assertEquals(i, teacher.getIdTeacher());
            assertEquals("Teacher " + (i + 1), teacher.getName());
        }
    }
    
    @Test
    public void testFindTeacherById() {
        assertEquals("Teacher 1", manageMapper.findById(0).getName());
        assertEquals("Teacher 5", manageMapper.findById(4).getName());
    }

}