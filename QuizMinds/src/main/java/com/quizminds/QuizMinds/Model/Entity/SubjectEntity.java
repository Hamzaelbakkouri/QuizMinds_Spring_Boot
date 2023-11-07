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
    private String title;

    @ManyToOne
    private SubjectEntity subject;

    @OneToMany(mappedBy = "subjectEntity")
    private List<QuestionEntity> questions;
}
