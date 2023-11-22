package com.quizminds.QuizMinds.Model.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "quiz")
@RequiredArgsConstructor
@NoArgsConstructor
public class QuizEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "quiz_sequence"
    )
    private int id;
    @NonNull
    @Min(0)
    @Column(name = "pass_score", nullable = false)
    private int passScore;
    @Min(0)
    @Max(3)
    @NonNull
    @Column(name = "chances", nullable = false)
    private int chances;
    @NonNull
    private String comment;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacherEntity;

    @OneToMany(mappedBy = "quizEntity")
    private List<AssignQuizEntity> assignQuizs;

    @OneToMany(mappedBy = "quizEntity")
    private List<QuizQuestionEntity> quizQuestionEntities;
}
