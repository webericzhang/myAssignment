package com.eric.library.core.persistence;

import java.util.List;

import com.eric.library.core.domain.DetailedCourse;
import com.eric.library.core.domain.DetailedTeacher;

public interface LibraryRepository {

    public List<DetailedCourse> listDetailedCourses();

    public DetailedCourse saveDetailedCourse(DetailedCourse course);
    
    public void deleteDetailedCourse(DetailedCourse course);
    
    public List<DetailedTeacher> listTeachers();
    
    public DetailedTeacher findTeacher(long teacher);

}
