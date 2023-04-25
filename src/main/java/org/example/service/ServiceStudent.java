package org.example.service;

import org.example.entity.Student;

import java.util.List;

public interface ServiceStudent {
    String saveStudent(Student student);

    Student getStudentById(Long id);

    String updateStudentById(Long id, Student student);

    List<Student> getAllSortedStudentsStudents();

    String deleteStudentById(Long id);

    List<Student> groupByGender(String maleOrFemale);

    Student getOldOrYoungerStudent();

    Student findStudentByFirstName(String name);
}
