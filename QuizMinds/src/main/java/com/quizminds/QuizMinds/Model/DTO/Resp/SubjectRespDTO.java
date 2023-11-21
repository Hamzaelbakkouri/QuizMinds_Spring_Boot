package com.quizminds.QuizMinds.Model.DTO.Resp;

import com.quizminds.QuizMinds.Model.DTO.QuestionDTO;
import com.quizminds.QuizMinds.Model.DTO.SubjectDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SubjectRespDTO {
    private int id;
    private String title;
    private SubjectDTO subject;
    private List<QuestionRespDTO> questions;
}
