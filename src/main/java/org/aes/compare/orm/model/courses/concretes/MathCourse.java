package org.aes.compare.orm.model.courses.concretes;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.aes.compare.orm.model.courses.abstracts.Course;
import org.aes.compare.orm.model.enums.course.EnumCourse;

@Entity
@DiscriminatorValue("MATH")
public class MathCourse extends Course {

    public MathCourse() {
        super(EnumCourse.MATH.getName(), 4);
    }

}
