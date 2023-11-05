package com.quizminds.QuizMinds.Repository;

import com.quizminds.QuizMinds.Model.Entity.TeacherEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity, String> {
    TeacherEntity findTeacherEntityByCodeOrEmail(@NonNull String code, @NonNull String email);
}
