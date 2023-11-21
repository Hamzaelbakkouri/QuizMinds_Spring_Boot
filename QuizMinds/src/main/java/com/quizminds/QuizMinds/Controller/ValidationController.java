package com.quizminds.QuizMinds.Controller;

import com.quizminds.QuizMinds.Interface.I_Validation;
import com.quizminds.QuizMinds.Model.DTO.Resp.ValidationRespDTO;
import com.quizminds.QuizMinds.Model.DTO.ValidationDTO;
import com.quizminds.QuizMinds.Model.Entity.AnswerQuestionEntity;
import com.quizminds.QuizMinds.Model.Entity.QuestionEntity;
import com.quizminds.QuizMinds.Model.Entity.ValidationEntity;
import com.quizminds.QuizMinds.Service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/validation")
public class ValidationController {
    @Autowired
    private final I_Validation validationService;

    public ValidationController(ValidationService validationService) {
        this.validationService = validationService;
    }

    @PostMapping(path = "/create")
    public ValidationRespDTO createValidation(@RequestBody ValidationDTO validationDTO) {
        return this.validationService.create(validationDTO);
    }

    @GetMapping(path = "/getall")
    public List<ValidationRespDTO> getAllValidation() {
        return this.validationService.getAll();
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteValidation(@PathVariable Integer id) {
        ValidationDTO validation = new ValidationDTO();
        validation.setId(id);
        return this.validationService.delete(validation);
    }

    @GetMapping(path = "/getone/{id}")
    public ResponseEntity getOneValidation(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        ValidationDTO validationDTO = new ValidationDTO();
        validationDTO.setId(id);
        Optional<ValidationRespDTO> validationDTO1 = this.validationService.get(validationDTO);
        if (validationDTO1.isPresent()) {
            result.put("validation", validationDTO1.get());
            return ResponseEntity.status(200).body(result);
        }
        result.put("message", "Validation not found");
        return ResponseEntity.status(404).body(result);
    }

}
