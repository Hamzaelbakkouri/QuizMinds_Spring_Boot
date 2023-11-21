package com.quizminds.QuizMinds.Service;

import com.quizminds.QuizMinds.Model.DTO.AssignQuizDTO;
import com.quizminds.QuizMinds.Model.DTO.QuizDTO;
import com.quizminds.QuizMinds.Model.DTO.StudentDTO;
import com.quizminds.QuizMinds.Model.Entity.AssignQuizEntity;
import com.quizminds.QuizMinds.Model.Entity.LevelEntity;
import com.quizminds.QuizMinds.Model.Entity.QuizEntity;
import com.quizminds.QuizMinds.Model.Entity.StudentEntity;
import com.quizminds.QuizMinds.Repository.AssignQuizRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssignQuizService {
    @Autowired
    private AssignQuizRepository assignQuizRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AssignQuizDTO create(AssignQuizDTO assignQuizEntity) {
        AssignQuizEntity assignQuizEntity1 = modelMapper.map(assignQuizEntity, AssignQuizEntity.class);
        return modelMapper.map(this.assignQuizRepository.save(assignQuizEntity1), AssignQuizDTO.class);
    }

    public List<AssignQuizDTO> getAll() {
        return this.assignQuizRepository.findAll().stream().map(assignQuizEntity -> modelMapper.map(assignQuizEntity, AssignQuizDTO.class)).collect(Collectors.toList());
    }

    public List<AssignQuizDTO> getAssignByQuiz(QuizDTO quizEntity) {
        QuizEntity quiz = modelMapper.map(quizEntity, QuizEntity.class);
        return this.assignQuizRepository.findAssignQuizEntityByQuizEntity(quiz).stream().map(assignQuizEntity -> modelMapper.map(assignQuizEntity, AssignQuizDTO.class)).collect(Collectors.toList());
    }

    public List<AssignQuizDTO> getAssignByStudent(StudentDTO student) {
        StudentEntity studentEntity = modelMapper.map(student, StudentEntity.class);
        return this.assignQuizRepository.findAssignQuizEntityByStudentEntity(studentEntity).stream().map(assignQuizEntity -> modelMapper.map(assignQuizEntity, AssignQuizDTO.class)).collect(Collectors.toList());
    }

    public String delete(AssignQuizDTO assignQuizEntity) {
        Optional<AssignQuizEntity> assignQuizEntityToCheck = this.assignQuizRepository.findById(assignQuizEntity.getId());
        if (assignQuizEntityToCheck.isPresent()) {
            this.assignQuizRepository.delete(assignQuizEntityToCheck.get());
            return "The Assign Quiz with id " + assignQuizEntity.getId() + "deleted successfully";
        }
        return "The Assign Quiz with id " + assignQuizEntity.getId() + "not found";
    }

    public AssignQuizDTO update(AssignQuizDTO assignQuizEntity) {
        Optional<AssignQuizEntity> existAssign = this.assignQuizRepository.findById(assignQuizEntity.getId());
        if (existAssign.isPresent()) {
            assignQuizEntity.setId(existAssign.get().getId());
            AssignQuizEntity assignQuizEntity1 = modelMapper.map(assignQuizEntity, AssignQuizEntity.class);
            return modelMapper.map(this.assignQuizRepository.save(assignQuizEntity1), AssignQuizDTO.class);
        }
        return null;
    }

}
