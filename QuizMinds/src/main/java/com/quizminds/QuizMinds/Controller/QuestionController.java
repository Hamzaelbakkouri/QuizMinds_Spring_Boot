package com.quizminds.QuizMinds.Controller;

import com.quizminds.QuizMinds.Model.DTO.QuestionDTO;
import com.quizminds.QuizMinds.Model.DTO.Resp.QuestionRespDTO;
import com.quizminds.QuizMinds.Model.Entity.QuestionEntity;
import com.quizminds.QuizMinds.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;


    @PostMapping(path = "/insert")
    public ResponseEntity createQuestion(@RequestBody QuestionDTO questionDTO) {
        Optional<QuestionRespDTO> questionRespDTO = Optional.ofNullable(this.questionService.create(questionDTO));
        return ResponseEntity.status(200).body(questionRespDTO.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Question not found")));
    }

    @GetMapping(path = "/getone/{id}")
    public ResponseEntity getOneQuestion(@PathVariable Integer id) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(id);
        Optional<QuestionRespDTO> questionRespDTO = this.questionService.get(questionDTO);
        if (questionRespDTO.isPresent()) {
            return ResponseEntity.status(200).body(questionRespDTO.get());
        }
        return ResponseEntity.status(404).body("Question not found");
    }

    @GetMapping(path = "/getall")
    public ResponseEntity getAllQuestion() {
        List<QuestionRespDTO> questions = this.questionService.getAll();
        if (questions != null) {
            return ResponseEntity.status(200).body(questions);
        }
        return ResponseEntity.status(404).body("No Question exist");
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteQuestion(@PathVariable Integer id) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(id);
        return ResponseEntity.ok().body(this.questionService.delete(questionDTO));
    }

}
