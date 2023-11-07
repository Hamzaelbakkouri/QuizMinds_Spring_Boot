package com.quizminds.QuizMinds.Controller;

import com.quizminds.QuizMinds.Model.Entity.SubjectEntity;
import com.quizminds.QuizMinds.Service.StudentService;
import com.quizminds.QuizMinds.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping(path = "/insert")
    public SubjectEntity createSubject(@RequestBody Map<String, Object> requestData) {
        if (requestData.containsKey("title") && requestData.containsKey("subject")) {
            String title = requestData.get("title").toString();
            Integer id = (Integer) requestData.get("subject");
            return this.subjectService.createSubject(title, id);
        } else {
            throw new IllegalArgumentException("Required data is missing in the request.");
        }
    }


    @PutMapping("/update/{id}")
    public SubjectEntity updateSubject(@PathVariable Integer id, @RequestBody Map<String, Object> requestData) {
        if (requestData.containsKey("title") && requestData.containsKey("subject")) {
            String title = requestData.get("title").toString();
            Integer code = (Integer) requestData.get("subject");
            return this.subjectService.updateSubject(title, code, id);
        } else {
            throw new IllegalArgumentException("Required data is missing in the request.");
        }
    }


    @GetMapping(path = "/getall")
    public List<SubjectEntity> getSubjects(@RequestBody SubjectEntity subject) {
        return subjectService.getSubjects();
    }


    @GetMapping("/search/{title}")
    public SubjectEntity getSubject(@PathVariable String title) {
        return subjectService.getSubject(title);
    }


    @DeleteMapping("delete/{id}")
    public Integer deleteSubject(@PathVariable Integer id) {
        return subjectService.deleteSubject(id);
    }

}