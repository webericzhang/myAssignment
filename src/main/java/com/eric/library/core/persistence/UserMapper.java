package com.eric.library.core.persistence;

import java.util.List;

import com.eric.library.core.domain.DetailedUser;

public interface UserMapper {

    public List<DetailedUser> listActiveCourses();
    
    public DetailedUser findById(long idCourse);

    public void save(DetailedUser course);
    
    public void delete(DetailedUser course);
    
    public void update(DetailedUser course);
}
