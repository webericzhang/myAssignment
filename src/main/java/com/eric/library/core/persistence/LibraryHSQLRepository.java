package com.eric.library.core.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eric.library.core.domain.DetailedUser;
import com.eric.library.core.domain.DetailedManage;

public class LibraryHSQLRepository implements LibraryRepository {

    @Autowired
    private final UserMapper UserMapper;
    @Autowired
    private final ManageMapper ManageMapper;

    public LibraryHSQLRepository(UserMapper UserMapper, ManageMapper ManageMapper) {
        this.UserMapper = UserMapper;
        this.ManageMapper = ManageMapper;
    }

    public List<DetailedUser> listDetailedUsers() {
        return UserMapper.listActiveCourses();
    }
    
    public DetailedUser saveDetailedUser(DetailedUser course) {
    	
        UserMapper.save(course);
        return course;
    }
    
    public void deleteDetailedUser(DetailedUser course) {
        UserMapper.delete(course);
    }
    
    public List<DetailedManage> listTeachers() {
        return ManageMapper.list();
    }

    public DetailedManage findTeacher(long idTeacher) {
        return ManageMapper.findById(idTeacher);
    }

}
