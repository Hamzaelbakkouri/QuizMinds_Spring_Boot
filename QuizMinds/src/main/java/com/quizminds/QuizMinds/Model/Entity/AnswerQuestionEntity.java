package com.quizminds.QuizMinds.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
public class AnswerQuestionEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "AnswerQuestion_sequence"
    )
    private int id;

    private String text;

    @OneToMany(mappedBy = "answerQuestion")
    private List<ValidationEntity> validations;
}
