package com.quizminds.QuizMinds.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class QuizQuestionEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "QuizQuestion_sequence"
    )
    private int id;
    @NonNull
    private LocalDateTime time;
    @NonNull
    private int score;
    @NonNull
    @ManyToOne
    private QuizEntity quizEntity;
    @NonNull
    @ManyToOne
    private QuestionEntity questionEntity;
}
