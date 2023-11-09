package com.quizminds.QuizMinds.Model.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.quizminds.QuizMinds.Model.Enum.QuestionQuiz;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.List;

@Entity
@Table
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Integer id;
    @NonNull
    private String text;
    @NonNull
    private QuestionQuiz type;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    @NonNull
    private SubjectEntity subject;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "level_id", referencedColumnName = "id")
    @NonNull
    private LevelEntity level;

    @JsonBackReference
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<ValidationEntity> validations;

    @JsonBackReference
    @OneToMany(mappedBy = "questionEntity", fetch = FetchType.LAZY)
    private List<QuizQuestionEntity> quizzQuestions;

}
