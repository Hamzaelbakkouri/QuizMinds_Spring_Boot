package com.quizminds.QuizMinds.Interface;

import com.quizminds.QuizMinds.Model.DTO.Resp.TeacherRespDTO;
import com.quizminds.QuizMinds.Model.DTO.TeacherDTO;
import com.quizminds.QuizMinds.Model.Entity.TeacherEntity;

public interface I_Teacher extends G_Type<TeacherDTO, String, TeacherRespDTO> {
    TeacherRespDTO update(TeacherDTO t, String code);
}
