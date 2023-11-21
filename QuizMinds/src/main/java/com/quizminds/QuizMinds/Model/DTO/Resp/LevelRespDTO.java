package com.quizminds.QuizMinds.Model.DTO.Resp;

import com.quizminds.QuizMinds.Model.DTO.QuestionDTO;
import com.quizminds.QuizMinds.Model.Enum.Level;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class LevelRespDTO {
    private int id;
    private Level levelType;
    private int maxPoint;
    private int minPoint;
    private List<QuestionDTO> questions;
}
