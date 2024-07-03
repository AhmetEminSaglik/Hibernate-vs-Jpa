package org.aes.compare.orm.model.courses.abstracts;

import jakarta.persistence.*;
import org.aes.compare.orm.model.Student;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "course")
public abstract class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @Column(name = "name")
//    private String name;

    @Column(name = "credits")
    private double credits;


    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private List<Student> students;


    public Course() {
        credits = 1;
    }

    public Course(double credits, List<Student> students) {
//        this.name = name;
        this.credits = credits;
        this.students = students;
    }

    public Course(double credits) {
        this.credits = credits;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public String getName() {
//        return name;
//    }

    public void setName(String name) {
//        this.name = name;
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
            System.out.println("Course'a student listesi olusturuldu");
            students = new ArrayList<>();
        }

        if (!students.contains(student)) {
            System.out.println("student eklendi");
            students.add(student);
            student.addCourse(this);
        } else {
            System.out.println("student zaten kayitli");
        }

    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
//                ", name='" + name + '\'' +
                ", credits=" + credits +
//                ", students=" + students +
                '}';
    }
}