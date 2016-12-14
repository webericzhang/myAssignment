package com.eric.library.core.persistence;

import java.util.List;

import com.eric.library.core.domain.DetailedCourse;

public interface CourseMapper {

    public List<DetailedCourse> listActiveCourses();
    
    public DetailedCourse findById(long idCourse);

    public void save(DetailedCourse course);
    
    public void delete(DetailedCourse course);
    
    public void update(DetailedCourse course);
}
