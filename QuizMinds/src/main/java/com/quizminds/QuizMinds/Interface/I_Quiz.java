package com.quizminds.QuizMinds.Interface;

import com.quizminds.QuizMinds.Model.DTO.QuizDTO;
import com.quizminds.QuizMinds.Model.DTO.Resp.QuizRespDTO;

public interface I_Quiz extends G_Type<QuizDTO, Integer, QuizRespDTO> {
    QuizRespDTO update(QuizDTO quizDTO);
}
