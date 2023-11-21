package com.quizminds.QuizMinds.Service;

import com.quizminds.QuizMinds.Exeptions.NotFoundExeption;
import com.quizminds.QuizMinds.Interface.I_Student;
import com.quizminds.QuizMinds.Model.DTO.QuizDTO;
import com.quizminds.QuizMinds.Model.DTO.Resp.QuizRespDTO;
import com.quizminds.QuizMinds.Model.Entity.LevelEntity;
import com.quizminds.QuizMinds.Model.Entity.QuizEntity;
import com.quizminds.QuizMinds.Model.Entity.StudentEntity;
import com.quizminds.QuizMinds.Model.Entity.TeacherEntity;
import com.quizminds.QuizMinds.Repository.QuizRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private ModelMapper modelMapper;

    public QuizRespDTO create(QuizDTO quizEntity) {
        QuizEntity quiz = modelMapper.map(quizEntity, QuizEntity.class);
        return modelMapper.map(this.quizRepository.save(quiz), QuizRespDTO.class);
    }

    public List<QuizRespDTO> getAll() {
        return this.quizRepository.findAll().stream().map(quizEntity -> modelMapper.map(quizEntity, QuizRespDTO.class)).collect(Collectors.toList());
    }

    public List<QuizRespDTO> getQuiSByTeacher(TeacherEntity teacher) {
        return this.quizRepository.findQuizEntitiesByTeacherEntity(teacher).stream().map(quizEntity -> modelMapper.map(quizEntity, QuizRespDTO.class)).collect(Collectors.toList());
    }

    public QuizRespDTO get(QuizRespDTO quizEntity) {
        QuizEntity quiz = this.quizRepository.findById(quizEntity.getId()).orElseThrow(() -> new NotFoundExeption("quiz not found"));
        return modelMapper.map(quiz, QuizRespDTO.class);
    }
}
