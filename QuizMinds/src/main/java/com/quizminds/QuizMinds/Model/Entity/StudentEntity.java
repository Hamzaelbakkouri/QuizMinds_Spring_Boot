package com.quizminds.QuizMinds.Model.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table
public final class StudentEntity extends PersonEntity {
    private LocalDate registrationDate;

    public StudentEntity(String code, String firstname, String lastname, LocalDate bd, String address, LocalDate registrationdate, String email) {
        super(code, firstname, lastname, bd, address, email);
        setRegistrationDate(registrationdate);
    }

    @OneToMany(mappedBy = "studentEntity")
    private List<AssignQuizEntity> assignQuizs;

    @OneToMany(mappedBy = "student")
    private List<AnswerStudentEntity> answerStudents;
}
