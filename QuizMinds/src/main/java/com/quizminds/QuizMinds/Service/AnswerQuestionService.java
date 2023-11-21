package com.quizminds.QuizMinds.Service;

import com.quizminds.QuizMinds.Model.DTO.AnswerQuestionDTO;
import com.quizminds.QuizMinds.Model.DTO.Resp.AnswerQuestionRespDTO;
import com.quizminds.QuizMinds.Model.Entity.AnswerQuestionEntity;
import com.quizminds.QuizMinds.Repository.AnswerQuestionRepository;
import jakarta.persistence.Entity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnswerQuestionService {
    @Autowired
    private AnswerQuestionRepository answerQuestionRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AnswerQuestionRespDTO create(AnswerQuestionDTO answerQuestion) {
        try {
            AnswerQuestionEntity answerQuestion1 = modelMapper.map(answerQuestion, AnswerQuestionEntity.class);
            return modelMapper.map(this.answerQuestionRepository.save(answerQuestion1), AnswerQuestionRespDTO.class);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<AnswerQuestionRespDTO> getAll() {
        try {
            return this.answerQuestionRepository.findAll().stream().map(answerQuestion -> modelMapper.map(answerQuestion, AnswerQuestionRespDTO.class)).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String delete(AnswerQuestionDTO answerQuestion) {
        try {
            Optional<AnswerQuestionEntity> answerQuestionToCheck = this.answerQuestionRepository.findById(answerQuestion.getId());
            if (answerQuestionToCheck.isPresent()) {
                this.answerQuestionRepository.deleteById(answerQuestion.getId());
                return "Answer with id " + answerQuestion.getId() + "deleted successfully";
            }
            return "Answer with id " + answerQuestion.getId() + "not found";
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
