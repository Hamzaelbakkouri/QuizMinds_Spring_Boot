package com.quizminds.QuizMinds.Repository;

import com.quizminds.QuizMinds.Model.Entity.StudentEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    public StudentEntity findStudentEntityByCodeOrEmail(@NonNull String code, @NonNull String email);
}
