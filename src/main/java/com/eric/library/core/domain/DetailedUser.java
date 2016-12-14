package com.eric.library.core.domain;

import com.eric.library.rest.domain.CreatingUserData;

public class DetailedUser {

    private long idCourse;
    private String title;
    private DetailedManage teacher;
    private UserLevel level;
    private float hoursLong;
    private boolean active;
    
    public long getIdCourse() {
        return idCourse;
    }
    public void setIdCourse(long idCourse) {
        this.idCourse = idCourse;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public DetailedManage getTeacher() {
        return teacher;
    }
    public void setTeacher(DetailedManage teacher) {
        this.teacher = teacher;
    }
    public UserLevel getLevel() {
        return level;
    }
    public void setLevel(UserLevel level) {
        this.level = level;
    }
    public float getHoursLong() {
        return hoursLong;
    }
    public void setHoursLong(float hoursLong) {
        this.hoursLong = hoursLong;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    
    public static DetailedUser fromCreatingCourseData(CreatingUserData courseData,
                                                        DetailedManage teacher,
                                                        UserLevel level) {
        DetailedUser detailedCourse = new DetailedUser();
        
        detailedCourse.title = courseData.getTitle();
        detailedCourse.teacher = teacher;
        detailedCourse.level = level;
        detailedCourse.hoursLong = courseData.getHoursLong();
        detailedCourse.active = courseData.isActive();
        
        return detailedCourse;
    }

}
