package com.quizminds.QuizMinds.Service;

import com.quizminds.QuizMinds.Interface.I_Question;
import com.quizminds.QuizMinds.Model.DTO.QuestionDTO;
import com.quizminds.QuizMinds.Model.DTO.Resp.QuestionRespDTO;
import com.quizminds.QuizMinds.Model.Entity.LevelEntity;
import com.quizminds.QuizMinds.Model.Entity.QuestionEntity;
import com.quizminds.QuizMinds.Model.Entity.SubjectEntity;
import com.quizminds.QuizMinds.Repository.LevelRepository;
import com.quizminds.QuizMinds.Repository.QuestionRepository;
import com.quizminds.QuizMinds.Repository.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService implements I_Question {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private LevelRepository levelRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public QuestionRespDTO create(QuestionDTO questionDTO) {
        LevelEntity level = modelMapper.map(questionDTO.getLevel(), LevelEntity.class);
        SubjectEntity subject = modelMapper.map(questionDTO.getSubject(), SubjectEntity.class);
        QuestionEntity question = modelMapper.map(questionDTO, QuestionEntity.class);
        question.setSubject(subject);
        question.setLevel(level);
        return modelMapper.map(questionRepository.save(question), QuestionRespDTO.class);
    }

    @Override
    public Optional<QuestionRespDTO> get(QuestionDTO questionDTO) {
        return Optional.ofNullable(modelMapper.map(this.questionRepository.findById(questionDTO.getId()).get(), QuestionRespDTO.class));
    }

    @Override
    public List<QuestionRespDTO> getAll() {
        return this.questionRepository.findAll().stream().map(questionEntity -> modelMapper.map(questionEntity, QuestionRespDTO.class)).collect(Collectors.toList());
    }

    @Override
    public String delete(QuestionDTO questionDTO) {
        Optional<QuestionEntity> isExist = this.questionRepository.findById(questionDTO.getId());
        if (isExist.isPresent()) {
            this.questionRepository.deleteById(questionDTO.getId());
            return "question with id : " + questionDTO.getId() + " delete successfully";
        }
        return "question with id : " + questionDTO.getId() + " not found";
    }
}
