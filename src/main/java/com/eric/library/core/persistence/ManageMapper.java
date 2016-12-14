package com.eric.library.core.persistence;

import java.util.List;

import com.eric.library.core.domain.DetailedManage;

public interface ManageMapper {

    public List<DetailedManage> list();

    public DetailedManage findById(long idTeacher);
}
