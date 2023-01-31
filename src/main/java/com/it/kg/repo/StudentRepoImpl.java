package com.it.kg.repo;

import com.it.kg.entity.Student;
import com.it.kg.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class StudentRepoImpl implements StudentRepo {

    @Override
    public Student getById(Long id) {
        Session session = HibernateUtil.getSession().openSession();
        return session.get(Student.class, id);
    }

    @Override
    public void save(Student student) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
        System.out.println("The student was successfully saved!");
    }

    @Override
    public List findAll() {
        Session session = HibernateUtil.getSession().openSession();
        return session.createQuery("select s from Student s").getResultList();
    }

    @Override
    public void update(Long id, Student newStudent) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        Student student = getById(id);
        student.setId(newStudent.getId());
        student.setFirstName(newStudent.getFirstName());
        student.setLastName(newStudent.getLastName());
        student.setAge(newStudent.getAge());
        session.saveOrUpdate(student);
        session.getTransaction().commit();
        System.out.println("The student has been successfully updated.");
    }

    @Override
    public void clear() {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from Student ");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Cleared!");
    }
}
