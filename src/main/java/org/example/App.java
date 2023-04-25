package org.example;

import org.example.config.Config;
import org.example.entity.Course;
import org.example.entity.Student;
import org.example.enums.Gender;
import org.example.service.serviceimpl.ServiceCourseImpl;
import org.example.service.serviceimpl.ServiceStudentImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       // Config.getEntityManager();
        ServiceCourseImpl serviceCourse = new ServiceCourseImpl();
        ServiceStudentImpl serviceStudent = new ServiceStudentImpl();
//        serviceCourse.saveCourse(new Course("Java",12000));
//        serviceCourse.getCourseById(1L);
//        serviceCourse.updateCourse(1L,new Course("Java9",8000));
//            serviceCourse.getAllCourses();
//        serviceCourse.deleteCourseById(1L);

//        serviceStudent.saveStudent(new Student("Manas","Abdugani uulu","manas@gmail.com",27, Gender.MALE));
//        System.out.println(serviceStudent.getStudentById(1L));
//        System.out.println(serviceStudent.updateStudentById(1L, new Student("Bek", "Toktomushev", "bek@gmail.com", 18, Gender.MALE)));
//        System.out.println(serviceStudent.getAllSortedStudentsStudents());
//        System.out.println(serviceStudent.groupByGender("MALE"));
//        System.out.println(serviceStudent.getOldOrYoungerStudent());
        System.out.println(serviceStudent.findStudentByFirstName("Bek"));
    }

}
