package org.aes.compare.orm.model.courses.concretes;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.aes.compare.orm.model.courses.abstracts.Course;

@Entity
@DiscriminatorValue("OTHER")
public class OtherCourse extends Course {

    public OtherCourse(String name, double credit) {
        super(name, credit);
    }

    public OtherCourse(Course course) {
        super(course);
    }

    public OtherCourse(String name) {
        super(name, 1);
    }

    public OtherCourse() {
        super("New Course Must be Typed here", -1);
    }

}
