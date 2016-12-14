package com.eric.library.core.event;

import java.util.List;

import com.eric.library.rest.domain.Management;

public class AllManageEvent {

    private final List<Management> teachers;

    public AllManageEvent(List<Management> teachers) {
        super();
        this.teachers = teachers;
    }

    public List<Management> getTeachers() {
        return teachers;
    }

}
