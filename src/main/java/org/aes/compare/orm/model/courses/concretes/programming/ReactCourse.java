package org.aes.compare.orm.model.courses.concretes.programming;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.aes.compare.orm.model.courses.abstracts.ProgrammingCourse;
import org.aes.compare.orm.model.enums.course.EnumCourse;

@Entity
@DiscriminatorValue("REACT")
public class ReactCourse extends ProgrammingCourse {

    public ReactCourse() {
        super(EnumCourse.REACT.getName(), 1.5);
    }

}
