package org.example.service.serviceimpl;

import org.example.dao.daoImpl.ServiceDaoCourseImpl;
import org.example.entity.Course;
import org.example.service.ServiceCourse;

import java.util.List;

public class ServiceCourseImpl implements ServiceCourse {
    ServiceDaoCourseImpl course = new ServiceDaoCourseImpl();
    public String saveCourse(Course newCourse) {
        return course.saveCourse(newCourse);
    }

    public Course getCourseById(Long id) {
        return course.getCourseById(id);
    }

    public String updateCourse(Long oldId, Course newCourse) {
        return course.updateCourse(oldId,newCourse);
    }

    public List<Course> getAllCourses() {
        return course.getAllCourses();
    }

    public String deleteCourseById(Long id) {
        return course.deleteCourseById(id);
    }
}
