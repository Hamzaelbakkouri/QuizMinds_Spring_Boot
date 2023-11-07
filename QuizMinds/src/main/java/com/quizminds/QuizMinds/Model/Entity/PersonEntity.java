package com.quizminds.QuizMinds.Model.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;

@Setter
@Getter
@MappedSuperclass
@RequiredArgsConstructor
@NoArgsConstructor
public abstract class PersonEntity {
    @Id
    @UuidGenerator
    private String id;
    @NonNull
    @Column(unique=true)
    private String code;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private LocalDate dateOfBirth;
    @NonNull
    private String address;
    @NonNull
    private String email;
}

