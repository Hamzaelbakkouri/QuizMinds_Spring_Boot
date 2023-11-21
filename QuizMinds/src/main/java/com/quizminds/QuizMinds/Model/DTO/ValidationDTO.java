package com.quizminds.QuizMinds.Model.DTO;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ValidationDTO {
    private int id;
    private int point;
    private QuestionDTO question;
    private AnswerQuestionDTO answerQuestion;
}
