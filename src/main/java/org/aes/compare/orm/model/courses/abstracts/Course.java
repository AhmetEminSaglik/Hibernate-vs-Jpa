package org.aes.compare.orm.model.courses.abstracts;

import jakarta.persistence.*;
import org.aes.compare.orm.model.Student;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "courses",uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "credits", nullable = false)
    private double credits;


    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
//    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Student> students;


    public Course(String name, double credits) {
        this.name = name;
        this.credits = credits;
    }

    public Course(double credits, List<Student> students) {
        this.credits = credits;
        this.students = students;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        if (students == null) {
            students = new ArrayList<>();
        }
        if (!students.contains(student)) {
            students.add(student);
            student.addCourse(this);
        }

    }

    @Override
    public String toString() {
        return getClass().getSimpleName().split("Course")[0] + "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                '}';
    }
}
