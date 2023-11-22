package com.quizminds.QuizMinds.Model.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public final class StudentEntity extends PersonEntity {
    private LocalDate registrationDate;

    public StudentEntity(String code, String firstname, String lastname, LocalDate bd, String address, String email) {
        setFirstName(firstname);
        setLastName(lastname);
        setCode(code);
        setDateOfBirth(bd);
        setAddress(address);
        setEmail(email);
    }

    @OneToMany(mappedBy = "studentEntity", fetch = FetchType.LAZY)
    private List<AssignQuizEntity> assignQuizs;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<AnswerStudentEntity> answerStudents;
}
