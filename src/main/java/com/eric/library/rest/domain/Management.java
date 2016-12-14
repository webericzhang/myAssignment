package com.eric.library.rest.domain;

import com.eric.library.core.domain.DetailedManage;

public class Management {

    private long idTeacher;
    private String name;

    public long getIdTeacher() {
        return idTeacher;
    }
    public String getName() {
        return name;
    }

    public static Management fromTeacher(DetailedManage teacher) {
        Management t = new Management();
        
        t.idTeacher = teacher.getIdTeacher();
        t.name = teacher.getName();
        
        return t;
    }
    
}
