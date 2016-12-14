package com.eric.library.core.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eric.library.core.domain.DetailedCourse;
import com.eric.library.core.domain.DetailedTeacher;

public class LibraryHSQLRepository implements LibraryRepository {

    @Autowired
    private final CourseMapper courseMapper;
    @Autowired
    private final ManageMapper ManageMapper;

    public LibraryHSQLRepository(CourseMapper courseMapper, ManageMapper ManageMapper) {
        this.courseMapper = courseMapper;
        this.ManageMapper = ManageMapper;
    }

    public List<DetailedCourse> listDetailedCourses() {
        return courseMapper.listActiveCourses();
    }
    
    public DetailedCourse saveDetailedCourse(DetailedCourse course) {
    	
        courseMapper.save(course);
        return course;
    }
    
    public void deleteDetailedCourse(DetailedCourse course) {
        courseMapper.delete(course);
    }
    
    public List<DetailedTeacher> listTeachers() {
        return ManageMapper.list();
    }

    public DetailedTeacher findTeacher(long idTeacher) {
        return ManageMapper.findById(idTeacher);
    }

}
