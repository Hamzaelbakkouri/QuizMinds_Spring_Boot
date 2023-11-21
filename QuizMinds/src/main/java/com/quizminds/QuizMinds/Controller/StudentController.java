package com.quizminds.QuizMinds.Controller;

import com.quizminds.QuizMinds.Model.DTO.Resp.StudentRespDTO;
import com.quizminds.QuizMinds.Model.DTO.StudentDTO;
import com.quizminds.QuizMinds.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/getall")
    public List<StudentRespDTO> getAllStudent() {
        return this.studentService.getAll();
    }

    @PostMapping(path = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insertStudent(@RequestBody StudentDTO student) {
        student.setRegistrationDate(LocalDate.now());
        StudentRespDTO studentRespDTO = this.studentService.create(student);
        return ResponseEntity.status(200).body(studentRespDTO);
    }

    @GetMapping(path = "/getone/{code}")
    public StudentRespDTO getOneStudent(@PathVariable String code) {
        StudentDTO student = new StudentDTO();
        student.setCode(code);
        Optional<StudentRespDTO> theNewStudent = this.studentService.get(student);
        return theNewStudent.orElse(null);
    }

    @DeleteMapping(path = "/delete/{code}")
    public ResponseEntity deleteStudent(@PathVariable String code) {
        Map<String, Object> result = new HashMap<>();
        StudentDTO student = new StudentDTO();
        student.setCode(code);
        String message = this.studentService.delete(student);
        result.put("message", message);
        return ResponseEntity.status(200).body(result);
    }

    @PutMapping("/update/{code}")
    public ResponseEntity updateAnswer(@PathVariable String code, @RequestBody StudentDTO student) {
        Map<String, Object> result = new HashMap<>();
        Optional<StudentRespDTO> studentRespDTO = Optional.ofNullable(this.studentService.update(code, student));
        if (studentRespDTO.isPresent()) {
            result.put("Student", studentRespDTO.get());
            return ResponseEntity.status(200).body(result);
        }
        result.put("message", "Student not Found");
        return ResponseEntity.status(404).body(result);
    }
}
