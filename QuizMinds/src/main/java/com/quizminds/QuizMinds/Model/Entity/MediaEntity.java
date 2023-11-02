package com.quizminds.QuizMinds.Model.Entity;

import com.quizminds.QuizMinds.Model.Enum.MediaType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Entity
@Table
@NoArgsConstructor
@RequiredArgsConstructor
public class MediaEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "MEDIA_sequence"
    )
    private int id;
    @NonNull
    private MediaType mediaType;
    @NonNull
    private String url;
    @NonNull
    private String decription;

    @OneToMany
    private List<QuestionEntity> questionEntities;

}
