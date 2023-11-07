package com.quizminds.QuizMinds.Repository;

import com.quizminds.QuizMinds.Model.Entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Integer> {
    Optional<SubjectEntity> findByTitle(String Title);
}
