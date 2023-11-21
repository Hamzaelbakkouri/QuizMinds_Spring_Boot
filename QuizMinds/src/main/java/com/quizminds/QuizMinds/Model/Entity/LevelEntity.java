package com.quizminds.QuizMinds.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.quizminds.QuizMinds.Model.Enum.Level;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class LevelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Level levelType;
    private int maxPoint;
    private int minPoint;

    @JsonIgnore
    @OneToMany(mappedBy = "level")
    private List<QuestionEntity> questions;
}
