package com.quizminds.QuizMinds.Model.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuizDTO {
    private int id;
    private int passScore;
    private int chances;
    private String comment;
    private TeacherDTO teacherEntity;
}
