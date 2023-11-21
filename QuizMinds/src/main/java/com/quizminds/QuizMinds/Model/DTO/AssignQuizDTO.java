package com.quizminds.QuizMinds.Model.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class AssignQuizDTO {
    private int id;
    private int chance;
    private LocalDate startDate;
    private LocalDate endDate;
    private double score;
    private String result;
    private QuizDTO quizEntity;
    private StudentDTO studentEntity;
}
