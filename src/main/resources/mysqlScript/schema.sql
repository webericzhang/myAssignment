-- clean up
DROP SEQUENCE coursesSeq IF EXISTS;
DROP TABLE courses IF EXISTS;
DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS teachers;

CREATE TABLE teachers (
    idTeacher int auto_increment primary key,
    name VARCHAR(255)
);

CREATE TABLE courses (
    idCourse int auto_increment primary key,
    title VARCHAR(255), 
    idTeacher int not null default '1', 
    level VARCHAR(32), 
    hoursLong FLOAT, 
    active BOOLEAN
);

ALTER TABLE courses
    ADD FOREIGN KEY (idTeacher)
    REFERENCES teachers(idTeacher);