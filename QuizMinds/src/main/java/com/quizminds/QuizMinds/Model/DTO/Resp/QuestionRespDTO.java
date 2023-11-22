package com.quizminds.QuizMinds.Model.DTO.Resp;

import com.quizminds.QuizMinds.Model.DTO.MediaDTO;
import com.quizminds.QuizMinds.Model.DTO.QuizQuestionDTO;
import com.quizminds.QuizMinds.Model.DTO.SubjectDTO;
import com.quizminds.QuizMinds.Model.DTO.ValidationDTO;
import com.quizminds.QuizMinds.Model.Entity.LevelEntity;
import com.quizminds.QuizMinds.Model.Enum.QuestionQuiz;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class QuestionRespDTO {
    private Integer id;
    private String text;
    private QuestionQuiz type;
    private SubjectDTO subject;
    private LevelEntity level;
    private List<ValidationDTO> validations;
    private List<QuizQuestionDTO> quizQuestions;
    private List<MediaDTO> medias;
}
