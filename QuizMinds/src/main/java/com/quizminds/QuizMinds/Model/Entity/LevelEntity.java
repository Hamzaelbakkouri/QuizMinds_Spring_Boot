package com.quizminds.QuizMinds.Model.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonMerge;
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
    private int maxPoint;
    private int minPoint;
    @OneToMany(mappedBy = "level")
    private List<QuestionEntity> questions;
}
