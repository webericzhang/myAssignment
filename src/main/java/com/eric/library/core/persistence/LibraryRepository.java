package com.eric.library.core.persistence;

import java.util.List;

import com.eric.library.core.domain.DetailedUser;
import com.eric.library.core.domain.DetailedManage;

public interface LibraryRepository {

    public List<DetailedUser> listDetailedUsers();

    public DetailedUser saveDetailedUser(DetailedUser course);
    
    public void deleteDetailedUser(DetailedUser course);
    
    public List<DetailedManage> listTeachers();
    
    public DetailedManage findTeacher(long teacher);

}
