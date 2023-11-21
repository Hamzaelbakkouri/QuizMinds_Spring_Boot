package com.quizminds.QuizMinds.Model.DTO.Resp;

import com.quizminds.QuizMinds.Model.DTO.AnswerStudentDTO;
import com.quizminds.QuizMinds.Model.DTO.AssignQuizDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class StudentRespDTO {
    private String code;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String address;
    private String email;
    private LocalDate registrationDate;
    private List<AssignQuizDTO> assignQuizs;
    private List<AnswerStudentDTO> answerStudents;
}
