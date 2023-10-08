package com.example.students_journal.entity;

import lombok.Getter;

import java.util.List;

@Getter
public class StudentData {
    private List<Student> data;
    private Long total;

    public StudentData() {
        super();
    }

    public void setData(List<Student> students) {
        this.data = students;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
