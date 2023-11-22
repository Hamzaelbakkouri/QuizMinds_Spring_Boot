package com.quizminds.QuizMinds.Controller;

import com.quizminds.QuizMinds.Model.DTO.QuizDTO;
import com.quizminds.QuizMinds.Model.DTO.Resp.QuizRespDTO;
import com.quizminds.QuizMinds.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping(path = "/getone/{id}")
    public ResponseEntity getOne(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        QuizDTO quizDTO = new QuizDTO();
        quizDTO.setId(id);
        Optional<QuizRespDTO> quizRespDTO = this.quizService.get(quizDTO);
        if (quizRespDTO.isPresent()) {
            result.put("Quiz", quizRespDTO.get());
            return ResponseEntity.status(200).body(result);
        } else {
            result.put("Message", "Quiz Not Found");
            return ResponseEntity.status(404).body(result);
        }
    }

    @GetMapping(path = "/getall")
    public ResponseEntity getAll() {
        Map<String, Object> result = new HashMap<>();
        List<QuizRespDTO> quizRespDTO = this.quizService.getAll();
        if (quizRespDTO != null) {
            result.put("Quizs", quizRespDTO);
            return ResponseEntity.status(200).body(result);
        } else {
            result.put("Message", "Quizs Not Found");
            return ResponseEntity.status(404).body(result);
        }
    }


}
