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

    @OneToMany(mappedBy = "questionEntity")
    private List<QuizQuestionEntity> quizQuestionEntities;

    @ManyToOne
    private LevelEntity levelEntity;

    @ManyToOne
    private MediaEntity mediaEntities;

    @OneToMany(mappedBy = "question")
    private List<ValidationEntity> validationEntities;
}
