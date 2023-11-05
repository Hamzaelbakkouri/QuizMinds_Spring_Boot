package com.quizminds.QuizMinds.Service;

import com.quizminds.QuizMinds.Model.Entity.StudentEntity;
import com.quizminds.QuizMinds.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public final class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentEntity> getAllStudent() {
        return this.studentRepository.findAll();
    }

    public StudentEntity insertStudent(StudentEntity studentEntity) {

        Optional<StudentEntity> studentOptional = Optional.ofNullable(studentRepository.findStudentEntityByCodeOrEmail(studentEntity.getCode(), studentEntity.getEmail()));
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("try different infos, something already taken");
        }
        StudentEntity student = this.studentRepository.save(studentEntity);
        return student;
    }

    public Optional<StudentEntity> getOneStudent(StudentEntity student) {
        return this.studentRepository.findById(student.getCode());
    }

    public Boolean deleteStudent(StudentEntity student) {
        try {
            this.studentRepository.deleteById(student.getCode());
            return true;
        } catch (Exception e) {
            new Exception("cant delete ,Something went wrong");
            return false;
        }
    }
}
