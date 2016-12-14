package com.eric.library.core.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eric.library.core.domain.DetailedManage;
import com.eric.library.core.event.AllManageEvent;
import com.eric.library.core.persistence.LibraryRepository;
import com.eric.library.rest.domain.Management;

public class ManageRequestsHandler implements ManageService {

    @Autowired
    private final LibraryRepository repository;
    
    public ManageRequestsHandler(LibraryRepository repository) {
        this.repository = repository;
    }
    
    public AllManageEvent requestAllTeachers() {
        List<Management> teachers = new LinkedList<Management>();
        
        for(DetailedManage teacher : repository.listTeachers()) {
            teachers.add(Management.fromTeacher(teacher));
        }
        
        return new AllManageEvent(teachers);
    }

}
