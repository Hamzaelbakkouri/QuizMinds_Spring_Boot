package com.quizminds.QuizMinds.Controller;

import com.quizminds.QuizMinds.Model.Entity.StudentEntity;
import com.quizminds.QuizMinds.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(name = "/getAll")
    public List<StudentEntity> getAllStudent() {
        return this.studentService.getAllStudent();
    }

    @PostMapping(name = "/insertstudent")
    public StudentEntity insertStudent(@RequestBody StudentEntity student) {
        return this.studentService.insertStudent(student);
    }

    @GetMapping(name = "/getone/{id}")
    public StudentEntity getOneStudent(@PathVariable String code) {
        StudentEntity student = new StudentEntity();
        student.setCode(code);
        Optional<StudentEntity> theNewStudent = this.studentService.getOneStudent(student);
        return theNewStudent.orElse(null);
    }

    @GetMapping(name = "/delete/{id}")
    public Boolean deleteStudent(@PathVariable String code) {
        StudentEntity student = new StudentEntity();
        student.setCode(code);
        return this.studentService.deleteStudent(student);
    }
}
