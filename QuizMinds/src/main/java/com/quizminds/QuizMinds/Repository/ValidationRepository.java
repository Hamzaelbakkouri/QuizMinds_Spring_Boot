package com.quizminds.QuizMinds.Repository;

import com.quizminds.QuizMinds.Model.DTO.ValidationDTO;
import com.quizminds.QuizMinds.Model.Entity.AnswerQuestionEntity;
import com.quizminds.QuizMinds.Model.Entity.QuestionEntity;
import com.quizminds.QuizMinds.Model.Entity.ValidationEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ValidationRepository extends JpaRepository<ValidationEntity, Integer> {
    List<ValidationEntity> findValidationEntityByQuestion(QuestionEntity questionEntity);

    ValidationEntity findValidationEntityByAnswerQuestion(AnswerQuestionEntity answerQuestion);
}
