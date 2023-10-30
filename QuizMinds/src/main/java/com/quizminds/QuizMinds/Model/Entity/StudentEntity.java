package com.quizminds.QuizMinds.Model.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table
public final class StudentEntity extends PersonEntity{
    private LocalDate registrationDate;
    public StudentEntity(String id , String firstname , String lastname,LocalDate bd,String address, LocalDate registrationdate){
        super(id,firstname,lastname,bd,address);
        setRegistrationDate(registrationdate);
    }
}
