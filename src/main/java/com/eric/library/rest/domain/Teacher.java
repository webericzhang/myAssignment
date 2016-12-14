package com.eric.library.rest.domain;

import com.eric.library.core.domain.DetailedTeacher;

public class Teacher {

    private long idTeacher;
    private String name;

    public long getIdTeacher() {
        return idTeacher;
    }
    public String getName() {
        return name;
    }

    public static Teacher fromTeacher(DetailedTeacher teacher) {
        Teacher t = new Teacher();
        
        t.idTeacher = teacher.getIdTeacher();
        t.name = teacher.getName();
        
        return t;
    }
    
}
