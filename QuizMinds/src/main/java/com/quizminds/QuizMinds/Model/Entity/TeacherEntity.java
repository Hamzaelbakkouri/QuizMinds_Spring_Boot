package com.quizminds.QuizMinds.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table
public final class TeacherEntity extends PersonEntity {
    private String speciality;

    @OneToMany(mappedBy = "teacherEntity", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<QuizEntity> quizEntity;

    public TeacherEntity(String code, String firstname, String lastname, LocalDate bd, String address, String email, String speciality) {
        setFirstName(firstname);
        setLastName(lastname);
        setCode(code);
        setDateOfBirth(bd);
        setAddress(address);
        setEmail(email);
        setSpeciality(speciality);
    }
}
