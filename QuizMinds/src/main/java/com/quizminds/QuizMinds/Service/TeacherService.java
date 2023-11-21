package com.quizminds.QuizMinds.Service;

import com.quizminds.QuizMinds.Interface.I_Teacher;
import com.quizminds.QuizMinds.Model.DTO.Resp.StudentRespDTO;
import com.quizminds.QuizMinds.Model.DTO.Resp.TeacherRespDTO;
import com.quizminds.QuizMinds.Model.DTO.Resp.ValidationRespDTO;
import com.quizminds.QuizMinds.Model.DTO.TeacherDTO;
import com.quizminds.QuizMinds.Model.Entity.StudentEntity;
import com.quizminds.QuizMinds.Model.Entity.TeacherEntity;
import com.quizminds.QuizMinds.Repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherService implements I_Teacher {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TeacherRespDTO> getAll() {
        return this.teacherRepository.findAll().stream().map(teacher -> modelMapper.map(teacher, TeacherRespDTO.class)).collect(Collectors.toList());
    }

    @Override
    public TeacherRespDTO create(TeacherDTO teacher) {
        Optional<TeacherEntity> teacherOptional = Optional.ofNullable(teacherRepository.findTeacherEntityByCodeOrEmail(teacher.getCode(), teacher.getEmail()));
        if (teacherOptional.isPresent()) {
            throw new IllegalStateException("try different infos, something already taken");
        }
        TeacherEntity teacher1 = modelMapper.map(teacher, TeacherEntity.class);
        return modelMapper.map(this.teacherRepository.save(teacher1), TeacherRespDTO.class);
    }

    @Override
    public Optional<TeacherRespDTO> get(TeacherDTO teacher) {
        return this.teacherRepository.findById(teacher.getCode()).map(validation -> modelMapper.map(validation, TeacherRespDTO.class));
    }

    @Override
    public String delete(TeacherDTO teacher) {
        try {
            this.teacherRepository.deleteById(teacher.getCode());
            return "Teacher deleted successfully";
        } catch (Exception e) {
            new Exception("cant delete ,Something went wrong");
            return "cant delete ,Something went wrong";
        }
    }

    @Override
    public TeacherRespDTO update(TeacherDTO teacherentity, String code) {
        Optional<TeacherEntity> studentTocheck = teacherRepository.findById(code);
        if (studentTocheck.isPresent()) {
            TeacherEntity teahcer1 = modelMapper.map(teacherentity, TeacherEntity.class);
            teahcer1.setId(code);
            return modelMapper.map(teacherRepository.save(teahcer1), TeacherRespDTO.class);
        }
        return null;
    }
}
