package com.eric.library.core.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eric.library.core.domain.DetailedTeacher;
import com.eric.library.core.event.AllTeachersEvent;
import com.eric.library.core.persistence.LibraryRepository;
import com.eric.library.rest.domain.Teacher;

public class TeacherRequestsHandler implements TeacherService {

    @Autowired
    private final LibraryRepository repository;
    
    public TeacherRequestsHandler(LibraryRepository repository) {
        this.repository = repository;
    }
    
    public AllTeachersEvent requestAllTeachers() {
        List<Teacher> teachers = new LinkedList<Teacher>();
        
        for(DetailedTeacher teacher : repository.listTeachers()) {
            teachers.add(Teacher.fromTeacher(teacher));
        }
        
        return new AllTeachersEvent(teachers);
    }

}
