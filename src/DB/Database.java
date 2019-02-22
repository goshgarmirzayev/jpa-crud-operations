package DB;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.entity.Student;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Goshgar
 */
public class Database {

    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAPU2");

    public static Student getStudentById(int id) {
        EntityManager em = factory.createEntityManager();
        Student student = em.find(Student.class, id);
        em.close();
        return student;
    }

    public static List<Student> getAll() {
        EntityManager em = factory.createEntityManager();
        List<Student> list;
        list = em.createQuery("select u from Student u").getResultList();
        return list;
    }

    public static boolean update(Student student) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    public static void insert(Student student) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();

    }

    public static void delete(int id) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        em.remove(student);
        em.getTransaction().commit();
        em.close();
    }
}
