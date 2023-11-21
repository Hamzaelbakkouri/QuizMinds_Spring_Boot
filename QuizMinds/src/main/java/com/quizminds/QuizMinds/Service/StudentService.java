package com.quizminds.QuizMinds.Service;

import com.quizminds.QuizMinds.Interface.I_Student;
import com.quizminds.QuizMinds.Model.DTO.Resp.StudentRespDTO;
import com.quizminds.QuizMinds.Model.DTO.StudentDTO;
import com.quizminds.QuizMinds.Model.Entity.StudentEntity;
import com.quizminds.QuizMinds.Repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class StudentService implements I_Student {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<StudentRespDTO> getAll() {
        return this.studentRepository.findAll().stream().map(student -> modelMapper.map(student, StudentRespDTO.class)).collect(Collectors.toList());
    }

    @Override
    public StudentRespDTO create(StudentDTO studentEntity) {
        Optional<StudentEntity> studentOptional = Optional.ofNullable(studentRepository.findStudentEntityByCodeOrEmail(studentEntity.getCode(), studentEntity.getEmail()));
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("try different infos, something already taken");
        }
        StudentEntity student1 = modelMapper.map(studentEntity, StudentEntity.class);
        return modelMapper.map(this.studentRepository.save(student1), StudentRespDTO.class);
    }

    @Override
    public Optional<StudentRespDTO> get(StudentDTO student) {
        return Optional.ofNullable(modelMapper.map(this.studentRepository.findStudentEntityByCode(student.getCode()), StudentRespDTO.class));
    }

    @Override
    public String delete(StudentDTO student) {
        try {
            this.studentRepository.deleteById(student.getCode());
            return "Student deleted successfully";
        } catch (Exception e) {
            new Exception("cant delete ,Something went wrong");
            return "cant delete ,Something went wrong";
        }
    }

    @Override
    public StudentRespDTO update(String code, StudentDTO updatedStudent) {
        Optional<StudentEntity> studentTocheck = studentRepository.findById(code);
        if (studentTocheck.isPresent()) {
            StudentEntity student1 = modelMapper.map(updatedStudent, StudentEntity.class);
            student1.setId(code);
            student1.setRegistrationDate(studentTocheck.get().getRegistrationDate());
            return modelMapper.map(studentRepository.save(student1), StudentRespDTO.class);
        }
        return null;
    }

}
