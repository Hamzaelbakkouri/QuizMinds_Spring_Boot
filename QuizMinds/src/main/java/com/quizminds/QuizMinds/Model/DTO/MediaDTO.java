package com.quizminds.QuizMinds.Model.DTO;

import com.quizminds.QuizMinds.Model.Enum.MediaType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MediaDTO {
    private int id;
    private MediaType mediaType;
    private String url;
    private String decription;
    private QuestionDTO questionEntity;
}
