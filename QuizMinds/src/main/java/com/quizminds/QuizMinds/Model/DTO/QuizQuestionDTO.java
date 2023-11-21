package com.quizminds.QuizMinds.Model.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class QuizQuestionDTO {
    private int id;
    private LocalDateTime time;
    private int score;
    private QuizDTO quizEntity;
    private QuestionDTO questionEntity;
}
