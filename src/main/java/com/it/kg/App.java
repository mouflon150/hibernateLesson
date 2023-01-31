package com.it.kg;

import com.it.kg.entity.Student;
import com.it.kg.repo.StudentRepoImpl;

public class App {

    public static void main(String[] args) {

        Student student1 = new Student("Marlen", "Temirbaev", 17);
        Student student2 = new Student("Bakyt", "Apsamatov", 16);
        Student student3 = new Student("Daniel", "Ahadzhanov", 15);

        StudentRepoImpl studentRepo = new StudentRepoImpl();

//        studentRepo.clear();
//        studentRepo.findAll().forEach(System.out::println);
    }
}