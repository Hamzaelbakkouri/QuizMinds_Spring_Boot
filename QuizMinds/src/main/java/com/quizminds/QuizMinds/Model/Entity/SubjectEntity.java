package com.quizminds.QuizMinds.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class SubjectEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "Subject_sequence"
    )
    private int id;
    @NonNull
    private String Title;
    @OneToOne
    private SubjectEntity subject;

    @OneToMany
    private List<QuestionEntity> questions;
}
