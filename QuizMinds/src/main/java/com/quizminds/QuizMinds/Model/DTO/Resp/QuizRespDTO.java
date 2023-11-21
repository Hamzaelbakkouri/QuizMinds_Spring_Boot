package com.quizminds.QuizMinds.Model.DTO.Resp;

import com.quizminds.QuizMinds.Model.DTO.AssignQuizDTO;
import com.quizminds.QuizMinds.Model.DTO.MediaDTO;
import com.quizminds.QuizMinds.Model.DTO.QuizQuestionDTO;
import com.quizminds.QuizMinds.Model.DTO.TeacherDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class QuizRespDTO {
    private int id;
    private int passScore;
    private int chances;
    private String comment;
    private TeacherDTO teacherEntity;
    private List<AssignQuizDTO> assignQuizs;
    private List<QuizQuestionDTO> quizQuestionEntities;
}
