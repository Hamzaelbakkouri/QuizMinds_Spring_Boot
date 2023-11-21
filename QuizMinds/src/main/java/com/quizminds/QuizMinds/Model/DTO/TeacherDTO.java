package com.quizminds.QuizMinds.Model.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class TeacherDTO {
    private String code;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String address;
    private String email;
    private String speciality;
}
