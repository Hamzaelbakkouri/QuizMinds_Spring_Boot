package com.quizminds.QuizMinds.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.quizminds.QuizMinds.Model.DTO.MediaDTO;
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
@Data
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String text;
    private QuestionQuiz type;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    @JsonIgnore
    private SubjectEntity subject;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "level_id", referencedColumnName = "id")
    private LevelEntity level;

    @JsonIgnore
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<ValidationEntity> validations;

    @JsonIgnore
    @OneToMany(mappedBy = "questionEntity", fetch = FetchType.LAZY)
    private List<QuizQuestionEntity> quizQuestions;

    @JsonIgnore
    @OneToMany(mappedBy = "questionEntity", fetch = FetchType.LAZY)
    private List<MediaEntity> medias;

}
