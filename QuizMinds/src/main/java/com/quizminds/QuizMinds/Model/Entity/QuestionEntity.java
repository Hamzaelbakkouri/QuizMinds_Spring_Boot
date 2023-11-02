package com.quizminds.QuizMinds.Model.Entity;

import com.quizminds.QuizMinds.Model.Enum.QuestionQuiz;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Entity
@Table
@RequiredArgsConstructor
@NoArgsConstructor
public class QuestionEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "AssignQuiz_sequence"
    )
    private int id;
    @NonNull
    private String text;
    @NonNull
    private QuestionQuiz questionQuiz;
    @NonNull
    @ManyToOne
    private SubjectEntity subjectEntity;

    @OneToMany
    private List<QuizQuestionEntity> quizQuestionEntities;

    @OneToOne
    private LevelEntity levelEntity;

    @OneToOne
    private MediaEntity mediaEntities;

    @OneToMany
    private List<ValidationEntity> validationEntities;
}
