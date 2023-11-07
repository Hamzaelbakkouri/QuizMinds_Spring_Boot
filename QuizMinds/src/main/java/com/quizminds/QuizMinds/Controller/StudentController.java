package com.quizminds.QuizMinds.Controller;

import com.quizminds.QuizMinds.Model.Entity.StudentEntity;
import com.quizminds.QuizMinds.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping(path = "/getall")
    public List<StudentEntity> getAllStudent() {
        return this.studentService.getAllStudent();
    }

    @PostMapping(path = "/addstudent")
    public StudentEntity insertStudent(@RequestBody StudentEntity student) {
        student.setRegistrationDate(LocalDate.now());
        return this.studentService.insertStudent(student);
    }

    @GetMapping(path = "/getone/{code}")
    public StudentEntity getOneStudent(@PathVariable String code) {
        StudentEntity student = new StudentEntity();
        student.setCode(code);
        Optional<StudentEntity> theNewStudent = Optional.ofNullable(this.studentService.getOneStudent(student));
        return theNewStudent.orElse(null);
    }

    @DeleteMapping(path = "/delete/{code}")
    public String deleteStudent(@PathVariable String code) {
        StudentEntity student = new StudentEntity();
        student.setId(code);
        return this.studentService.deleteStudent(student);
    }

    @PutMapping("/update/{code}")
    public StudentEntity updateAnswer(@PathVariable String code, @RequestBody StudentEntity student) {
        return studentService.updateStudent(code, student);
    }
}
