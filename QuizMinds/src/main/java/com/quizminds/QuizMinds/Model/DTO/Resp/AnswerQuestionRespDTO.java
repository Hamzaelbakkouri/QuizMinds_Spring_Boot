package com.quizminds.QuizMinds.Model.DTO.Resp;

import com.quizminds.QuizMinds.Model.DTO.ValidationDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AnswerQuestionRespDTO {
    private int id;
    private String text;
    private List<ValidationDTO> validations;
}
