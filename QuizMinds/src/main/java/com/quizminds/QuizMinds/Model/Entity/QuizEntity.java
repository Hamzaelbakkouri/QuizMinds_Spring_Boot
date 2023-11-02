package com.quizminds.QuizMinds.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "quiz")
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class QuizEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "quiz_sequence"
    )
    private int id;
    @NonNull
    @Column(name = "pass_score", nullable = false)
    private int passScore;
    @NonNull
    @Column(name = "chances", nullable = false)
    private int chances;
    @NonNull
    private String comment;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacherEntity;
    @OneToMany(mappedBy = "quizEntity")
    private List<AssignQuizEntity> assignQuizs;

    @OneToMany(mappedBy = "quizEntity")
    private List<QuizQuestionEntity> quizQuestionEntities;
}
