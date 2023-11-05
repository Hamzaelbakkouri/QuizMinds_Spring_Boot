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
public final class TeacherEntity extends PersonEntity {
    private String speciality;
    @OneToMany(mappedBy = "teacherEntity")
    private List<QuizEntity> quizEntity;

    public TeacherEntity(String code, String firstname, String lastname, LocalDate bd, String address, String speciality, String email) {
        super(code, firstname, lastname, bd, address, email);
        setSpeciality(speciality);
    }

    @OneToMany(mappedBy = "teacherEntity")
    private List<QuizEntity> quizs;
}