package com.eric.library.core.persistence;

import java.util.List;

import com.eric.library.core.domain.DetailedTeacher;

public interface ManageMapper {

    public List<DetailedTeacher> list();

    public DetailedTeacher findById(long idTeacher);
}
