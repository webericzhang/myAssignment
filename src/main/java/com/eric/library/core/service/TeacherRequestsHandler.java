package com.eric.library.core.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eric.library.core.domain.DetailedManage;
import com.eric.library.core.event.AllTeachersEvent;
import com.eric.library.core.persistence.LibraryRepository;
import com.eric.library.rest.domain.Management;

public class TeacherRequestsHandler implements TeacherService {

    @Autowired
    private final LibraryRepository repository;
    
    public TeacherRequestsHandler(LibraryRepository repository) {
        this.repository = repository;
    }
    
    public AllTeachersEvent requestAllTeachers() {
        List<Management> teachers = new LinkedList<Management>();
        
        for(DetailedManage teacher : repository.listTeachers()) {
            teachers.add(Management.fromTeacher(teacher));
        }
        
        return new AllTeachersEvent(teachers);
    }

}
