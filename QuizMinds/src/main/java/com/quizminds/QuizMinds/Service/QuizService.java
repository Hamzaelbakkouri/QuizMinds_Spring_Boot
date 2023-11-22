package com.quizminds.QuizMinds.Service;

import com.quizminds.QuizMinds.Exeptions.InsertionException;
import com.quizminds.QuizMinds.Exeptions.NotFoundExeption;
import com.quizminds.QuizMinds.Interface.I_Quiz;
import com.quizminds.QuizMinds.Model.DTO.QuizDTO;
import com.quizminds.QuizMinds.Model.DTO.Resp.QuestionRespDTO;
import com.quizminds.QuizMinds.Model.DTO.Resp.QuizRespDTO;
import com.quizminds.QuizMinds.Model.DTO.Resp.TeacherRespDTO;
import com.quizminds.QuizMinds.Model.Entity.QuestionEntity;
import com.quizminds.QuizMinds.Model.Entity.QuizEntity;
import com.quizminds.QuizMinds.Model.Entity.SubjectEntity;
import com.quizminds.QuizMinds.Model.Entity.TeacherEntity;
import com.quizminds.QuizMinds.Repository.QuizRepository;
import com.quizminds.QuizMinds.Repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService implements I_Quiz {
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public QuizRespDTO create(QuizDTO quizEntity) {
        try {
            Optional<TeacherEntity> teacherToPut = Optional.of(this.teacherRepository.findTeacherEntityByCode(quizEntity.getTeacherEntity().getCode()));
            if (teacherToPut.isPresent()) {
                QuizEntity quizentity1 = modelMapper.map(quizEntity, QuizEntity.class);
                quizentity1.setTeacherEntity(teacherToPut.get());
                return modelMapper.map(this.quizRepository.save(quizentity1), QuizRespDTO.class);
            } else {
                throw new NotFoundExeption("Teacher Not Found");
            }
        } catch (Exception e) {
            throw new InsertionException("Quiz insertion failed", e);
        }
    }

    @Override
    public String delete(QuizDTO quizDTO) {
        try {
            Optional<QuizEntity> quizEntity = this.quizRepository.findById(quizDTO.getId());
            if (quizEntity.isPresent()) {
                this.quizRepository.deleteById(quizEntity.get().getId());
                return "Quiz With id : " + quizEntity.get().getId() + " Deleted Successfully";
            } else {
                return "Quiz With id : " + quizEntity.get().getId() + " Failed to Delete";
            }
        } catch (NotFoundExeption e) {
            throw new NotFoundExeption("Quiz Not Found");
        }
    }

    @Override
    public List<QuizRespDTO> getAll() {
        try {
            return this.quizRepository.findAll().stream().map(quizEntity -> modelMapper.map(quizEntity, QuizRespDTO.class)).collect(Collectors.toList());
        } catch (NotFoundExeption e) {
            throw new NotFoundExeption("There No Quiz");
        }
    }

    @Override
    public Optional<QuizRespDTO> get(QuizDTO quizEntity) {
        try {
            QuizEntity quiz = this.quizRepository.findById(quizEntity.getId()).orElseThrow(() -> new NotFoundExeption("quiz not found"));
            return Optional.of(modelMapper.map(quiz, QuizRespDTO.class));
        } catch (NotFoundExeption e) {
            throw new NotFoundExeption("There No Quiz");
        }
    }

    @Override
    public QuizRespDTO update(QuizDTO quizDTO) {
        try {
            Optional<QuizEntity> quizEntity = this.quizRepository.findById(quizDTO.getId());
            if (quizEntity.isPresent()) {
                QuizEntity quiz = new QuizEntity();
                quiz.setId(quizEntity.get().getId());
                return modelMapper.map(this.quizRepository.save(quiz), QuizRespDTO.class);
            } else {
                throw new NotFoundExeption("Quiz with id : " + quizDTO.getId() + " Not Found");
            }
        } catch (Exception e) {
            throw new InsertionException("quiz update failed", e);
        }
    }
}
