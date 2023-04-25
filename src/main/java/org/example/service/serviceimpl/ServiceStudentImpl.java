package org.example.service.serviceimpl;

import org.example.dao.daoImpl.ServiceDaoStudentImpl;
import org.example.entity.Student;
import org.example.service.ServiceStudent;

import java.util.List;

public class ServiceStudentImpl implements ServiceStudent {
    ServiceDaoStudentImpl student1 = new ServiceDaoStudentImpl();
    public String saveStudent(Student student) {
        return student1.saveStudent(student);
    }

    public Student getStudentById(Long id) {
        return student1.getStudentById(id);
    }

    public String updateStudentById(Long id, Student student) {
        return student1.updateStudentById(id,student);
    }

    public List<Student> getAllSortedStudentsStudents() {
        return student1.getAllSortedStudentsStudents();
    }

    public String deleteStudentById(Long id) {
        return student1.deleteStudentById(id);
    }

    public List<Student> groupByGender(String maleOrFemale) {
        return student1.groupByGender(maleOrFemale);
    }

    public Student getOldOrYoungerStudent() {
        return student1.getOldOrYoungerStudent();
    }

    public Student findStudentByFirstName(String name) {
        return student1.findStudentByFirstName(name);
    }
}
