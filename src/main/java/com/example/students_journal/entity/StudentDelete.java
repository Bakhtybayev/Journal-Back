package com.example.students_journal.entity;
import lombok.Getter;
@Getter
public class StudentDelete {
    private String status;
    private String studentName;

    public StudentDelete() {
        super();
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
