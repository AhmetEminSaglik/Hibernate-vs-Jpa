package org.aes.compare.orm.model;

import jakarta.persistence.*;
import org.aes.compare.orm.model.courses.abstracts.Course;

@Entity
@Table(name = "exam_result")
public class ExamResult {
//todo, course data degisirse, OneToOne course ile burasida etkilencek mi?
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "score")
    private double score;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;
//    @ManyToOne(fetch = FetchType.LAZY)
//    private  Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id"/*, nullable = false*/)
    private Student student;

    public ExamResult() {
    }

    public ExamResult(double score ,Course course/*, Student student*/) {
        this.score = score;
        this.course = course;
//        this.student = student;
    }
    public  void setStudent(Student student){
        this.student=student;
        student.addExamResult(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    /*   public String getCourse() {
            return course;
        }

        public void setCourse(String course) {
            this.course = course;
        }
    */
    public Student getStudent() {
        return student;
    }

//    public void setStudent(Student student) {
//        this.student = student;
//    }

    @Override
    public String toString() {
        return "ExamResult{" +
                "id=" + id +
                ", score=" + score +
                ", course='" + course + '\'' +
//                ", student=" + student +
                '}';
    }
}