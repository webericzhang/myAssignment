package com.eric.library.core.persistence;

import java.util.List;

import com.eric.library.core.domain.DetailedTeacher;

public interface TeacherMapper {

    public List<DetailedTeacher> list();

    public DetailedTeacher findById(long idTeacher);
}
