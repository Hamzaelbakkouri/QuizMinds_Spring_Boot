package com.quizminds.QuizMinds.Controller;


import com.quizminds.QuizMinds.Model.DTO.AnswerQuestionDTO;
import com.quizminds.QuizMinds.Model.DTO.Resp.AnswerQuestionRespDTO;
import com.quizminds.QuizMinds.Model.Entity.AnswerQuestionEntity;
import com.quizminds.QuizMinds.Service.AnswerQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/questionanswer")
public class QuestionAnswercController {
    @Autowired
    private AnswerQuestionService answerQuestionService;


    @PostMapping(path = "/insert")
    public AnswerQuestionRespDTO createAnswerQuestion(@RequestBody AnswerQuestionDTO answerQuestion) {
        return this.answerQuestionService.create(answerQuestion);
    }

    @GetMapping(path = "/getall")
    public List<AnswerQuestionRespDTO> getAllQuestionAnswers() {
        return this.answerQuestionService.getAll();
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteAnswer(Integer id) {
        AnswerQuestionDTO answerQuestion = new AnswerQuestionDTO();
        answerQuestion.setId(id);
        return this.answerQuestionService.delete(answerQuestion);
    }
}
