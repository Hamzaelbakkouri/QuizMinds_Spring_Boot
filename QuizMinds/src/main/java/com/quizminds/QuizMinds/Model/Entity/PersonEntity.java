package com.quizminds.QuizMinds.Model.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;

@Setter
@Getter
@MappedSuperclass
@NoArgsConstructor
public abstract class PersonEntity {
    @Id
    @UuidGenerator
    private String id;

    @Column(unique=true)
    private String code;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private String address;

    private String email;
}

