package com.quizminds.QuizMinds.Repository;

import com.quizminds.QuizMinds.Model.Entity.QuizEntity;
import com.quizminds.QuizMinds.Model.Entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<QuizEntity, Integer> {
    List<QuizEntity> findQuizEntitiesByTeacherEntity(TeacherEntity teacherEntity);
}
