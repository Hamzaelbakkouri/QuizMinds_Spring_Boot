package com.quizminds.QuizMinds.Model.Entity;

import com.quizminds.QuizMinds.Model.Enum.Level;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class LevelEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "Level_sequence"
    )
    private int id;
    @NonNull
    private String description;
    @NonNull
    private Level level;
    @NonNull
    @ManyToOne
    private QuestionEntity questionEntity;

    @OneToMany
    private List<QuestionEntity> questionEntities;
}
