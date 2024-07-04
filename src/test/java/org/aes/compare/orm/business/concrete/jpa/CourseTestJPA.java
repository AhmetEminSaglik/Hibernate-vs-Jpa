package org.aes.compare.orm.business.concrete.jpa;

import org.aes.compare.orm.business.abstracts.CourseService;
import org.aes.compare.orm.model.EnumCourse;
import org.aes.compare.orm.model.courses.abstracts.Course;
import org.aes.compare.orm.model.courses.concretes.LiteratureCourse;
import org.aes.compare.orm.model.courses.concretes.MathCourse;
import org.aes.compare.orm.model.courses.concretes.OtherCourse;
import org.aes.compare.orm.model.courses.concretes.ScienceCourse;
import org.aes.compare.orm.model.courses.concretes.programming.FlutterCourse;
import org.aes.compare.orm.model.courses.concretes.programming.JavaCourse;
import org.junit.jupiter.api.*;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class
CourseTestJPA {
    private static CourseService courseService = new CourseServiceImplJPA();

    @Test
    @Order(1)
    public void testSaveCourse() {
        courseService.resetTable();
        saveCourseData();
        int expected = 7;
        int actual = courseService.findAll().size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(2)
    public void testFindCourseByName() {
        courseService.resetTable();
        saveCourseData();
        Course course = courseService.findByName(EnumCourse.MATH.getName());
        long expected = 1;
        long actual = course.getId();
        Assertions.assertEquals(expected, actual);

        course = courseService.findByName(EnumCourse.JAVA.getName());
        expected = 4;
        actual = course.getId();
        Assertions.assertEquals(expected, actual);

        course = courseService.findByName("Piano");
        expected = 6;
        actual = course.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(3)
    public  void testDeleteCourseByName(){
        courseService.resetTable();
        saveCourseData();
        courseService.deleteCourseByName(EnumCourse.MATH.getName());
        List<Course> courses = courseService.findAll();

        courses.forEach(
                e -> {
                    if (e.getName().equals(EnumCourse.MATH.getName())) {
                        Assertions.fail("This data must be deleted : " + e);
                    }
                }
        );

    }

    @Test
    @Order(4)
    public void testDeleteCourseById() {
        courseService.resetTable();
        saveCourseData();
        courseService.deleteCourseById(2);
        List<Course> courses = courseService.findAll();
        courses.forEach(
                e -> {
                    if (e.getId() == 2) {
                        Assertions.fail("This data must be deleted : " + e);
                    }
                }
        );
    }

    @Test
    @Order(5)
    public void testUpdateCourse() {
        courseService.resetTable();
        saveCourseData();
        Course course = courseService.findByName(EnumCourse.JAVA.getName());
        course.setCredits(6.5);
        courseService.updateCourseByName(course);
    }

    @Test
    @Order(6)
    public void testDeleteAllCourses() {
        courseService.resetTable();
        testSaveCourse();
    }

    private void saveCourseData() {
        Course courseMath = new MathCourse();
        Course courseScience = new ScienceCourse();
        Course courseLiterature = new LiteratureCourse();

        Course courseJava = new JavaCourse();
        Course courseFlutter = new FlutterCourse();
        Course courseOtherPiano = new OtherCourse("Piano");
        Course courseUnity = new OtherCourse("Unity");

        courseService.save(courseMath);
        courseService.save(courseScience);
        courseService.save(courseLiterature);
        courseService.save(courseJava);
        courseService.save(courseFlutter);
        courseService.save(courseOtherPiano);
        courseService.save(courseUnity);
    }

}
