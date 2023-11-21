package com.quizminds.QuizMinds.Model.DTO.Resp;

import com.quizminds.QuizMinds.Model.DTO.AnswerQuestionDTO;
import com.quizminds.QuizMinds.Model.DTO.QuestionDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ValidationRespDTO {
    private int id;
    private int point;
    private QuestionDTO question;
    private AnswerQuestionDTO answerQuestion;
    private List<AnswerQuestionDTO> answerQuestionEntities;
}
