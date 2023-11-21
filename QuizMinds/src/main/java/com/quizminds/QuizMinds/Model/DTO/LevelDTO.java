package com.quizminds.QuizMinds.Model.DTO;


import com.quizminds.QuizMinds.Model.Enum.Level;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LevelDTO {
    private int id;
    private Level levelType;
    private int maxPoint;
    private int minPoint;
}
