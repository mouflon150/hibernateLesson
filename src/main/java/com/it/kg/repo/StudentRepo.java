package com.it.kg.repo;

import com.it.kg.entity.Student;

import java.util.List;

public interface StudentRepo {

    Student getById(Long id);

    void save(Student student);

    List<Student> findAll();

    void update(Long id, Student newStudent);

    void clear();
}
