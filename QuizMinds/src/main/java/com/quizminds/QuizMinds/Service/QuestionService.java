package com.quizminds.QuizMinds.Service;

import com.quizminds.QuizMinds.Model.Entity.QuestionEntity;
import com.quizminds.QuizMinds.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public QuestionEntity createQuestion(QuestionEntity questionEntity) {
        return this.questionRepository.save(questionEntity);
    }

    public Optional<QuestionEntity> getOneQuestion(Integer id) {
        return this.questionRepository.findById(id);
    }

    public List<QuestionEntity> getAllQuestion() {
        return this.questionRepository.findAll();
    }

    public Boolean deleteQuestion(Integer id) {
        Optional<QuestionEntity> isExist = this.questionRepository.findById(id);
        if (isExist.isPresent()) {
            this.questionRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
