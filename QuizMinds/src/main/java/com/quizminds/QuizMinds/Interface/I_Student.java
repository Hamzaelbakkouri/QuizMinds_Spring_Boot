package com.quizminds.QuizMinds.Interface;

import com.quizminds.QuizMinds.Model.DTO.Resp.StudentRespDTO;
import com.quizminds.QuizMinds.Model.DTO.StudentDTO;

public interface I_Student extends G_Type<StudentDTO, String, StudentRespDTO> {
    StudentRespDTO update(String code, StudentDTO t);
}
