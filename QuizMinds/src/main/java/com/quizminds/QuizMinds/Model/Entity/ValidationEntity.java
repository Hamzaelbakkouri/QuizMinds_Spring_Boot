package com.quizminds.QuizMinds.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table

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
    @ManyToOne(fetch = FetchType.LAZY)
    private QuestionEntity question;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private AnswerQuestionEntity answerQuestion;

}
