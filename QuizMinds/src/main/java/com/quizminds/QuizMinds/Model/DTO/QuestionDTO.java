package com.quizminds.QuizMinds.Model.DTO;

import com.quizminds.QuizMinds.Model.Enum.QuestionQuiz;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class QuestionDTO {
    private Integer id;
    private String text;
    private QuestionQuiz type;
    private SubjectDTO subject;
    private LevelDTO level;
}
