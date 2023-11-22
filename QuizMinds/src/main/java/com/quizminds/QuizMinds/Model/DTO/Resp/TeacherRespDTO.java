package com.quizminds.QuizMinds.Model.DTO.Resp;

import com.quizminds.QuizMinds.Model.DTO.QuizDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class TeacherRespDTO {
    private String code;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String address;
    private String email;
    private String speciality;
    private List<QuizDTO> quizEntity;
}
