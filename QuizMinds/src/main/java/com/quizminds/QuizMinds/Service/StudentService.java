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
        return this.studentRepository.save(studentEntity);
    }

    public StudentEntity getOneStudent(StudentEntity student) {
        return this.studentRepository.findStudentEntityByCode(student.getCode());
    }

    public String deleteStudent(StudentEntity student) {
        try {
            this.studentRepository.deleteById(student.getId());
            return "Student deleted successfully";
        } catch (Exception e) {
            new Exception("cant delete ,Something went wrong");
            return "cant delete ,Something went wrong";
        }
    }

    public StudentEntity updateStudent(String code, StudentEntity updatedStudent) {
        if (studentRepository.findById(code).isPresent()) {
            updatedStudent.setId(code);
            return studentRepository.save(updatedStudent);
        }
        return null;
    }

}
