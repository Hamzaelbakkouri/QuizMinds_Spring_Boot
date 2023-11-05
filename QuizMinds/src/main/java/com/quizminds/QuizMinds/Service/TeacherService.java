package com.quizminds.QuizMinds.Service;

import com.quizminds.QuizMinds.Model.Entity.TeacherEntity;
import com.quizminds.QuizMinds.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<TeacherEntity> getAllTeacher() {
        return this.teacherRepository.findAll();
    }

    public Optional<TeacherEntity> insertTeacher(TeacherEntity teacher) {

        Optional<TeacherEntity> teacherOptional = Optional.of(teacher);
        if (teacherOptional.isPresent()) {
            throw new IllegalStateException("try different infos, something already taken");
        }
        return Optional.of(this.teacherRepository.save(teacher));
    }

    public Optional<TeacherEntity> getOneTeacher(TeacherEntity teacher) {
        return this.teacherRepository.findById(teacher.getCode());
    }

    public Boolean deleteTeacher(TeacherEntity teacher) {
        try {
            this.teacherRepository.deleteById(teacher.getCode());
            return true;
        } catch (Exception e) {
            new Exception("cant delete ,Something went wrong");
            return false;
        }
    }
}
