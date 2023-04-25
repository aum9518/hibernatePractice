package org.example.dao.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.example.config.Config;
import org.example.dao.serviceDaoCourse;
import org.example.entity.Course;

import java.util.List;

public class ServiceDaoCourseImpl implements serviceDaoCourse {
    EntityManagerFactory entityManagerFactory = Config.getEntityManager();
    public String saveCourse(Course newCourse) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(newCourse);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully saved!";
    }

    public Course getCourseById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
//        entityManager.find(Course.class,id);
        Query query =  entityManager.createQuery("select c from Course c where c.id = :id")
                .setParameter("id",id);
        Course course = (Course) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;

    }

    public String updateCourse(Long oldId, Course newCourse) {
        EntityManager entity = entityManagerFactory.createEntityManager();
        entity.getTransaction().begin();
    Query query = entity.createQuery("update  Course c set c.name = :name, c.price = :price where c.id = :id")
            .setParameter("name",newCourse.getName())
        .setParameter("price",newCourse.getPrice())
            .setParameter("id",oldId);
    query.executeUpdate();
    entity.getTransaction().commit();
    entity.close();
        return "Successfully updated"+query;
    }

    public List<Course> getAllCourses() {
        EntityManager entity = entityManagerFactory.createEntityManager();
        entity.getTransaction().begin();
        List<Course> list = entity.createQuery("select c from Course c",Course.class).getResultList();
        entity.getTransaction().commit();
        entity.close();
        return list;
    }

    public String deleteCourseById(Long id) {
        EntityManager entity = entityManagerFactory.createEntityManager();
        entity.getTransaction().begin();
//        Course course = entity.createQuery("delete  Course c where c.id = :id",Course.class)
//                .setParameter("id",id).getSingleResult();
        Course course = entity.find(Course.class,id);
        entity.remove(course);
        entity.getTransaction().commit();
        entity.close();
        return "Successfully deleted"+ course;
    }
}
