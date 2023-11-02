package com.quizminds.QuizMinds.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public abstract class PersonEntity {
    @Id
    @GeneratedValue( 
            strategy = GenerationType.SEQUENCE,
            generator = "Person_sequence"
    )
    @SequenceGenerator(
            name = "Person_sequence",
            sequenceName = "Person_sequence",
            allocationSize = 1
    )
    @NonNull
    private String id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private LocalDate dateOfBirth;
    @NonNull
    private String address;

}

