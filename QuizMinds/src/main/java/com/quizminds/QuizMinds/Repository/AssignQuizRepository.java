package com.quizminds.QuizMinds.Repository;

import com.quizminds.QuizMinds.Model.Entity.AssignQuizEntity;
import com.quizminds.QuizMinds.Model.Entity.QuizEntity;
import com.quizminds.QuizMinds.Model.Entity.StudentEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignQuizRepository extends JpaRepository<AssignQuizEntity, Integer> {
    List<AssignQuizEntity> findAssignQuizEntityByQuizEntity(QuizEntity quizEntity);

    List<AssignQuizEntity> findAssignQuizEntityByStudentEntity(StudentEntity student);
}
