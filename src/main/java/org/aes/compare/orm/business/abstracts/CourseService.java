package org.aes.compare.orm.business.abstracts;

import org.aes.compare.orm.model.courses.abstracts.Course;

public interface CourseService {
    Course save(Course c);

    Course findByName(String name);

    void deleteCourseByName(String name);

    void deleteCourseById(int id);

    Course updateCourseByName(Course course);

    void deleteAll();
}
