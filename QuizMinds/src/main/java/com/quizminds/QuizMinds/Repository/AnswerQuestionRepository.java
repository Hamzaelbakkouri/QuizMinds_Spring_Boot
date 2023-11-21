package com.quizminds.QuizMinds.Repository;

import com.quizminds.QuizMinds.Model.Entity.AnswerQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerQuestionRepository extends JpaRepository<AnswerQuestionEntity, Integer> {
}
