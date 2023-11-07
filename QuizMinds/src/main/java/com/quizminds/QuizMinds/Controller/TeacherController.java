package com.quizminds.QuizMinds.Controller;

import com.quizminds.QuizMinds.Model.Entity.TeacherEntity;
import com.quizminds.QuizMinds.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @GetMapping(path = "/getall")
    public List<TeacherEntity> getAllTeacher(){
        return this.teacherService.getAllTeacher();
    }

    @PostMapping(path = "/insert")
    public TeacherEntity insertTeacher(@RequestBody TeacherEntity teacherEntity) {
        Optional<TeacherEntity> optionalTeacher = this.teacherService.insertTeacher(teacherEntity);
        return optionalTeacher.get();
    }

    @GetMapping(path = "/getone/{code}")
    public TeacherEntity getOneTeacher(@PathVariable String code) {
        TeacherEntity Teacher = new TeacherEntity();
        Teacher.setCode(code);
        Optional<TeacherEntity> theNewTeacher = Optional.ofNullable(this.teacherService.getOneTeacher(Teacher));
        return theNewTeacher.orElse(null);
    }

    @DeleteMapping(path = "/delete/{code}")
    public String deleteStudent(@PathVariable String code) {
        TeacherEntity teacher = new TeacherEntity();
        teacher.setId(code);
        return this.teacherService.deleteTeacher(teacher);
    }

    @PutMapping("/update/{code}")
    public TeacherEntity update(@PathVariable String code, @RequestBody TeacherEntity Teacher) {
        return this.teacherService.updateTeacher(Teacher,code);
    }
}
