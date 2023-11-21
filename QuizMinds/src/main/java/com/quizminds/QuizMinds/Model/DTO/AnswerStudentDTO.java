package com.quizminds.QuizMinds.Model.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnswerStudentDTO {
    private int id;
    private int student;
    private QuestionDTO question;
    private QuizDTO quiz;
}
