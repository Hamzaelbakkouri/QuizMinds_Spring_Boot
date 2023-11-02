package com.quizminds.QuizMinds.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@RequiredArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AnswerStudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "AnswerStudent_sequence")
    private int id;

    @NonNull
    @ManyToOne
    private StudentEntity student;

    @NonNull
    @ManyToOne
    private QuestionEntity question;

    @NonNull
    @ManyToOne
    private QuizEntity quiz;
}
