package com.quizminds.QuizMinds.Controller;

import com.quizminds.QuizMinds.Model.Entity.QuestionEntity;
import com.quizminds.QuizMinds.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/question")
public class QuestionController {
    QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping(path = "/insert")
    public QuestionEntity createQuestion(@RequestBody QuestionEntity questionEntity) {
        return this.questionService.createQuestion(questionEntity);
    }

    @GetMapping(path = "/getone/{id}")
    public QuestionEntity getOneQuestion(@PathVariable Integer id) {
        return this.questionService.getOneQuestion(id).get();
    }

    @GetMapping(path = "/getall")
    public List<QuestionEntity> getAllQuestion() {
        return this.questionService.getAllQuestion();
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteQuestion(@PathVariable Integer id) {
        if (this.questionService.deleteQuestion(id)) {
            return "question with id : " + id + "deleted successfully";
        }
        return "you cant delete question with id : " + id;
    }
}
