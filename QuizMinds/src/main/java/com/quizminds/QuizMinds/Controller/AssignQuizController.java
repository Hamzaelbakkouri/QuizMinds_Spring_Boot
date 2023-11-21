package com.quizminds.QuizMinds.Controller;

import com.quizminds.QuizMinds.Model.DTO.AssignQuizDTO;
import com.quizminds.QuizMinds.Model.DTO.QuizDTO;
import com.quizminds.QuizMinds.Model.DTO.StudentDTO;
import com.quizminds.QuizMinds.Model.Entity.AssignQuizEntity;
import com.quizminds.QuizMinds.Model.Entity.QuizEntity;
import com.quizminds.QuizMinds.Model.Entity.StudentEntity;
import com.quizminds.QuizMinds.Service.AssignQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/assignquiz")
public class AssignQuizController {
    @Autowired
    private AssignQuizService assignQuizService;

    @PostMapping(path = "/insert")
    public AssignQuizDTO createAssignQuiz(@RequestBody AssignQuizDTO assignQuizEntity) {
        return this.assignQuizService.create(assignQuizEntity);
    }

    @GetMapping(path = "/getassign/quiz/{id}")
    public List<AssignQuizDTO> assignsByQuiz(@PathVariable Integer id) {
        QuizDTO quizEntity = new QuizDTO();
        quizEntity.setId(id);
        return this.assignQuizService.getAssignByQuiz(quizEntity);
    }

    @GetMapping(path = "/getassign/student/{code}")
    public List<AssignQuizDTO> assignsByStudent(@PathVariable String code) {
        StudentDTO student = new StudentDTO();
        student.setCode(code);
        return this.assignQuizService.getAssignByStudent(student);
    }

    @GetMapping(path = "/getall")
    public List<AssignQuizDTO> getAllAssigns() {
        return this.assignQuizService.getAll();
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteAssign(@PathVariable Integer id) {
        AssignQuizDTO assignQuizEntity = new AssignQuizDTO();
        assignQuizEntity.setId(id);
        return this.assignQuizService.delete(assignQuizEntity);
    }

    @PutMapping(path = "/update/{id}")
    public AssignQuizDTO updateAssign(@RequestBody AssignQuizDTO assignQuizEntity, @PathVariable Integer id) {
        assignQuizEntity.setId(id);
        return this.assignQuizService.update(assignQuizEntity);
    }
}
