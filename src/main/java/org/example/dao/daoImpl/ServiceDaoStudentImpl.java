package org.example.dao.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.config.Config;
import org.example.dao.serviceDaoStudent;
import org.example.entity.Student;

import java.util.List;

public class ServiceDaoStudentImpl implements serviceDaoStudent {
    EntityManagerFactory entityManagerFactory = Config.getEntityManager();
    public String saveStudent(Student student) {
        EntityManager entity = entityManagerFactory.createEntityManager();
        entity.getTransaction().begin();
        entity.persist(student);
        entity.getTransaction().commit();
        entity.close();
        return "Successfully saved!";
    }

    public Student getStudentById(Long id) {
        EntityManager entity = entityManagerFactory.createEntityManager();
        entity.getTransaction().begin();
        Student student = entity.find(Student.class,id);
        entity.getTransaction().commit();
        entity.close();
        return student;
    }

    public String updateStudentById(Long id, Student student) {
        EntityManager entity = entityManagerFactory.createEntityManager();
        entity.getTransaction().begin();
        Student student1 = entity.find(Student.class,id);
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setGender(student.getGender());
        student1.setEmail(student.getEmail());
        student1.setAge(student.getAge());
        entity.getTransaction().commit();
        entity.close();
        return "Successfully updated "+student;
    }

    public List<Student> getAllSortedStudentsStudents() {
        EntityManager entity = entityManagerFactory.createEntityManager();
        entity.getTransaction().begin();
       List<Student>students= entity.createQuery("select s from Student s  order by s.firstName ",Student.class).getResultList();
        entity.getTransaction().commit();
        entity.close();
        return students;
    }

    public String deleteStudentById(Long id) {
        EntityManager entity = entityManagerFactory.createEntityManager();
        entity.getTransaction().begin();
        Student student = entity.find(Student.class,id);
        entity.remove(student);
        entity.getTransaction().commit();
        entity.close();
        return "Successfully deleted";
    }

    public List<Student> groupByGender(String maleOrFemale) {
        EntityManager entity = entityManagerFactory.createEntityManager();
        entity.getTransaction().begin();
        List<Student>students = entity.createQuery("select s from Student s where s.gender = :maleOrFemale",Student.class)
                        .setParameter("maleOrFemale",maleOrFemale).getResultList();
        entity.getTransaction().commit();
        entity.close();
        return students;
    }

    public Student getOldOrYoungerStudent() {
        EntityManager entity = entityManagerFactory.createEntityManager();
        entity.getTransaction().begin();
        Student student = entity.createQuery("select  s from Student s order by s.age asc limit 1",Student.class).getSingleResult();
        entity.getTransaction().commit();
        entity.close();
        return student;
    }

    public Student findStudentByFirstName(String name) {
        EntityManager entity = entityManagerFactory.createEntityManager();
        entity.getTransaction().begin();
        Student student = entity.createQuery("select s from Student s where s.firstName = :name",Student.class)
                        .setParameter("name",name).getSingleResult();
        entity.getTransaction().commit();
        entity.close();
        return student;
    }
}
