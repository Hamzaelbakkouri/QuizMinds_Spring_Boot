package com.quizminds.QuizMinds.Controller;

import com.quizminds.QuizMinds.Model.DTO.QuizDTO;
import com.quizminds.QuizMinds.Model.DTO.Resp.QuizRespDTO;
import com.quizminds.QuizMinds.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "api/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping(path = "/insert")
    public ResponseEntity createQuiz(@RequestBody QuizDTO quizDTO) {
        Map<String, Object> result = new HashMap<>();
        QuizRespDTO quizRespDTO = this.quizService.create(quizDTO);
        if (quizRespDTO != null) {
            result.put("quiz", quizDTO);
            return ResponseEntity.status(200).body(result);
        }
        result.put("message", "quiz failed to create");
        return ResponseEntity.status(404).body(result);
    }
}
