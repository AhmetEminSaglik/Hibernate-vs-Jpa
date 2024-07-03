package org.aes.compare.orm.business.concrete.jpa;

import org.aes.compare.orm.business.abstracts.StudentService;
import org.aes.compare.orm.model.Address;
import org.aes.compare.orm.model.ExamResult;
import org.aes.compare.orm.model.Student;
import org.aes.compare.orm.model.courses.abstracts.Course;
import org.aes.compare.orm.model.courses.concretes.LiteratureCourse;
import org.aes.compare.orm.model.courses.concretes.MathCourse;
import org.aes.compare.orm.model.courses.concretes.ScienceCourse;
import org.aes.compare.orm.model.courses.concretes.programming.FlutterCourse;
import org.aes.compare.orm.model.courses.concretes.programming.JavaCourse;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Random;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JpaImplementationTest {
    private static StudentService studentService = new StudentServiceImpJPA();

    @Test
    @Order(1)
    public void SaveCoreStudentTest() {
        Student student = new Student();
        student.setName("Ahmet");
        student.setGrade(1);
        studentService.save(student);
        System.out.println("Student is saved : " + student);
    }

    @Test
    @Order(2)
    public void SaveStudentWithAddressTest() {
        Address address = new Address("Street abc", "Ankara", "Spain");

        Student student = new Student();
        student.setName("Emin");
        student.setGrade(1);
        student.setAddress(address);
        studentService.save(student);
        System.out.println("Student is saved : " + student);

    }


    @Test
    @Order(3)
    public void SaveStudentWithAddressAndCourseTest() {
        Address address = new Address("Street abc", "Ankara", "Spain");

        Student student = new Student();
        student.setName("Saglik");
        student.setGrade(1);
        student.setAddress(address);

        Course courseMath = new MathCourse();
        Course courseScience = new ScienceCourse();
        Course courseLiterature = new LiteratureCourse();
        Course courseJava = new JavaCourse();
        Course courseFlutter = new FlutterCourse();

        student.addCourse(courseMath);
        student.addCourse(courseScience);
        student.addCourse(courseLiterature);
        student.addCourse(courseJava);
        student.addCourse(courseFlutter);


        studentService.save(student);
        System.out.println("Student is saved : " + student);
    }

    /*@Test
    public  void test(){
        Random random = new Random();
        System.out.println(random.nextDouble(10d));
        System.out.println(random.nextDouble());
    }*/
    @Test
    @Order(4)
    public void SaveStudentWithAddressAndCourseAndExamResultTest() {

        Address address = new Address("Street abc", "Ankara", "Spain");

        Student student = new Student();
        student.setName("Saglik");
        student.setGrade(1);
        student.setAddress(address);

        Course courseMath = new MathCourse();
        Course courseScience = new ScienceCourse();
        Course courseLiterature = new LiteratureCourse();
        Course courseJava = new JavaCourse();
        Course courseFlutter = new FlutterCourse();

        ExamResult examResultMath = new ExamResult(getRandomExamResult(), courseMath);
        ExamResult examResultScience = new ExamResult(getRandomExamResult(), courseScience);
        ExamResult examResultLiterature = new ExamResult(getRandomExamResult(), courseLiterature);
        ExamResult examResultJava = new ExamResult(getRandomExamResult(), courseJava);
        ExamResult examResultFlutter = new ExamResult(getRandomExamResult(), courseFlutter);

        student.addCourse(courseMath);
        student.addCourse(courseScience);
        student.addCourse(courseLiterature);
        student.addCourse(courseJava);
        student.addCourse(courseFlutter);


        student.addExamResult(examResultMath);
        student.addExamResult(examResultScience);
        student.addExamResult(examResultLiterature);
        student.addExamResult(examResultJava);
        student.addExamResult(examResultFlutter);


        studentService.save(student);
        System.out.println("Student is saved : " + student);
    }

    Random random = new Random();

    private double getRandomExamResult() {
        return (random.nextInt(10000) / 100.0);
    }

}