package com.quizminds.QuizMinds.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public final class AssignQuizEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "AssignQuiz_sequence"
    )
    private int id;
    @NonNull
    private int chance;
    @NonNull
    private LocalDate startDate;
    @NonNull
    private LocalDate endDate;
    @NonNull
    private double score;
    @NonNull
    private String result;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private QuizEntity quizEntity;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity studentEntity;
}
