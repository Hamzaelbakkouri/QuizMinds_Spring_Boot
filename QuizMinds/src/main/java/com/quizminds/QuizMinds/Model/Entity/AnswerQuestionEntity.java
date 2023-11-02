package com.quizminds.QuizMinds.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class AnswerQuestionEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "AnswerQuestion_sequence"
    )
    private int id;
    @NonNull
    private String text;
    @NonNull
    @OneToMany
    private List<ValidationEntity> validations;
}
