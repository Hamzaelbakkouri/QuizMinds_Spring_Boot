package com.quizminds.QuizMinds.Controller;

import com.quizminds.QuizMinds.Model.DTO.Resp.TeacherRespDTO;
import com.quizminds.QuizMinds.Model.DTO.TeacherDTO;
import com.quizminds.QuizMinds.Model.Entity.TeacherEntity;
import com.quizminds.QuizMinds.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping(path = "/getall")
    public List<TeacherRespDTO> getAllTeacher() {
        return this.teacherService.getAll();
    }

    @PostMapping(path = "/insert")
    public TeacherRespDTO insertTeacher(@RequestBody TeacherDTO teacherEntity) {
        return this.teacherService.create(teacherEntity);
    }

    @GetMapping(path = "/getone/{code}")
    public TeacherRespDTO getOneTeacher(@PathVariable String code) {
        TeacherDTO Teacher = new TeacherDTO();
        Teacher.setCode(code);
        Optional<TeacherRespDTO> theNewTeacher = this.teacherService.get(Teacher);
        return theNewTeacher.orElse(null);
    }

    @DeleteMapping(path = "/delete/{code}")
    public String deleteStudent(@PathVariable String code) {
        TeacherDTO teacher = new TeacherDTO();
        teacher.setCode(code);
        return this.teacherService.delete(teacher);
    }

    @PutMapping("/update/{code}")
    public ResponseEntity update(@PathVariable String code, @RequestBody TeacherDTO Teacher) {
        Map<String, Object> result = new HashMap<>();
        Optional<TeacherRespDTO> teacherRespDTO = Optional.ofNullable(this.teacherService.update(Teacher, code));
        if (teacherRespDTO.isPresent()) {
            result.put("Teacher", teacherRespDTO.get());
            return ResponseEntity.status(200).body(result);
        }
        result.put("message", "Teacher not Found");
        return ResponseEntity.status(404).body(result);
    }
}
