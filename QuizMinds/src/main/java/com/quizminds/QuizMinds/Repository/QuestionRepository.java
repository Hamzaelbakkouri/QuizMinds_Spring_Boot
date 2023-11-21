package com.quizminds.QuizMinds.Repository;

import com.quizminds.QuizMinds.Model.DTO.Resp.QuestionRespDTO;
import com.quizminds.QuizMinds.Model.Entity.LevelEntity;
import com.quizminds.QuizMinds.Model.Entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer> {
    List<QuestionEntity> findAllByLevel(LevelEntity level);

    List<QuestionEntity> findAllBySubject(QuestionEntity subject);
}
