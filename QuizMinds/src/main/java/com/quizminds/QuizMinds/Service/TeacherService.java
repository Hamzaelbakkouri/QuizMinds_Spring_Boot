package com.quizminds.QuizMinds.Service;

import com.quizminds.QuizMinds.Model.Entity.StudentEntity;
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

        Optional<TeacherEntity> teacherOptional = Optional.ofNullable(this.teacherRepository.findTeacherEntityByCodeOrEmail(teacher.getCode(), teacher.getEmail()));
        if (teacherOptional.isPresent()) {
            throw new IllegalStateException("try different infos, something already taken");
        }
        return Optional.of(this.teacherRepository.save(teacher));
    }

    public TeacherEntity getOneTeacher(TeacherEntity teacher) {
        return this.teacherRepository.findTeacherEntityByCode(teacher.getCode());
    }

    public String deleteTeacher(TeacherEntity teacher) {
        try {
            this.teacherRepository.deleteById(teacher.getId());
            return "Teacher deleted successfully";
        } catch (Exception e) {
            new Exception("cant delete ,Something went wrong");
            return "cant delete ,Something went wrong";
        }
    }

    public TeacherEntity updateTeacher(TeacherEntity teacherentity, String code) {
        if (teacherRepository.findById(code).isPresent()) {
            teacherentity.setId(code);
            return teacherRepository.save(teacherentity);
        }
        return null;
    }
}
