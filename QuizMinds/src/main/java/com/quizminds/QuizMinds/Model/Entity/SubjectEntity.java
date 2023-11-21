package com.quizminds.QuizMinds.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table
public class SubjectEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "Subject_sequence"
    )
    private int id;
    @Column(unique = true)
    private String title;

    @ManyToOne
    private SubjectEntity subject;

    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<QuestionEntity> questions;
}
