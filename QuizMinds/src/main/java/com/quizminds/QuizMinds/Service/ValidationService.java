package com.quizminds.QuizMinds.Service;

import com.quizminds.QuizMinds.Exeptions.NotFoundExeption;
import com.quizminds.QuizMinds.Interface.I_Validation;
import com.quizminds.QuizMinds.Model.DTO.QuestionDTO;
import com.quizminds.QuizMinds.Model.DTO.Resp.ValidationRespDTO;
import com.quizminds.QuizMinds.Model.DTO.ValidationDTO;
import com.quizminds.QuizMinds.Model.Entity.*;
import com.quizminds.QuizMinds.Repository.AnswerQuestionRepository;
import com.quizminds.QuizMinds.Repository.QuestionRepository;
import com.quizminds.QuizMinds.Repository.ValidationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ValidationService implements I_Validation {
    @Autowired
    private ValidationRepository validationRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerQuestionRepository answerQuestionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ValidationRespDTO create(ValidationDTO validationEntity) {
        QuestionEntity question = this.questionRepository.findById(validationEntity.getQuestion().getId()).orElseThrow(() -> new NotFoundExeption("question not found"));
        AnswerQuestionEntity answerQuestion = this.answerQuestionRepository.findById(validationEntity.getAnswerQuestion().getId()).orElseThrow(() -> new NotFoundExeption("answerQuestion not found "));
        ValidationEntity validation = modelMapper.map(validationEntity, ValidationEntity.class);
        validation.setQuestion(question);
        validation.setAnswerQuestion(answerQuestion);
        return modelMapper.map(validationRepository.save(validation), ValidationRespDTO.class);
    }

    @Override
    public String delete(ValidationDTO validationEntity) {
        validationRepository.findById(validationEntity.getId()).orElseThrow(() -> new NotFoundExeption("Validation not found with id " + validationEntity.getId()));
        validationRepository.deleteById(validationEntity.getId());
        return "validation with id " + validationEntity.getId() + "delete successfully";
    }

    @Override
    public Optional<ValidationRespDTO> get(ValidationDTO validationEntity) {
        return Optional.of(modelMapper.map(this.validationRepository.findById(validationEntity.getId()).get(), ValidationRespDTO.class));
    }

    @Override
    public List<ValidationRespDTO> getAll() {
        return validationRepository.findAll().stream().map(validation -> modelMapper.map(validation, ValidationRespDTO.class)).collect(Collectors.toList());
    }

}
