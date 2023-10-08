package com.example.students_journal.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Data
@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue
    private int id;
    private String studentName;
    private String studentFrom;
    private String email;
    private String phone;
    private String gender;
    private String faculty;
    private String assessment;
    private String semester;
    private String lastname;
    private String educationStartYear;
    private String educationEndYear;

//    public Student(int id, String name, String lastname, String from, String semester, String email, String phone, String gender, String faculty, int assessment, int educationStartYear, int educationEndYear) {
//        this.id = id;
//        this.name = name;
//        this.lastname = lastname;
//        this.from = from;
//        this.semester = semester;
//        this.email = email;
//        this.phone = phone;
//        this.gender = gender;
//        this.faculty = faculty;
//        this.assessment = assessment;
//        this.educationStartYear = educationStartYear;
//        this.educationEndYear = educationEndYear;
//    }

    public Student() {
        super();
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setStudentFrom(String studentFrom) {
        this.studentFrom = studentFrom;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }

    public void setEducationStartYear(String educationStartYear) {
        this.educationStartYear = educationStartYear;
    }

    public void setEducationEndYear(String educationEndYear) {
        this.educationEndYear = educationEndYear;
    }
}