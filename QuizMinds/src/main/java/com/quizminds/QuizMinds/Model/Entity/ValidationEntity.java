package com.quizminds.QuizMinds.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class ValidationEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "validation_sequence"
    )
    private int id;
    @NonNull
    private int point;
    @NonNull
    @ManyToOne
    private QuestionEntity question;
    @NonNull
    @ManyToOne
    private AnswerQuestionEntity answerQuestion;
}
