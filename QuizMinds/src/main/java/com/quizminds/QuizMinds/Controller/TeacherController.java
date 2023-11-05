package com.quizminds.QuizMinds.Controller;

import com.quizminds.QuizMinds.Model.Entity.TeacherEntity;
import com.quizminds.QuizMinds.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping(name = "/insert")
    public TeacherEntity insertTeacher(TeacherEntity teacherEntity) {
        Optional<TeacherEntity> optionalTeacher = this.teacherService.insertTeacher(teacherEntity);
        return optionalTeacher.get();
    }

//    @GetMapping
//    public
}
