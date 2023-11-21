package com.quizminds.QuizMinds.Model.DTO;

import com.quizminds.QuizMinds.Model.Enum.QuestionQuiz;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class QuestionDTO {
    private Integer id;
    private String text;
    private QuestionQuiz type;
    private SubjectDTO subject;
    private LevelDTO level;
}
