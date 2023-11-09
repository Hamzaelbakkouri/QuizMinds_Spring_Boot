package com.quizminds.QuizMinds.Service;

import com.quizminds.QuizMinds.Model.Entity.SubjectEntity;
import com.quizminds.QuizMinds.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public SubjectEntity getSubject(String name) {
        return subjectRepository.findByTitle(name).get();
    }

    public List<SubjectEntity> getSubjects() {
        return subjectRepository.findAll();
    }

    public SubjectEntity createSubject(String title, Integer id) {
        Optional<SubjectEntity> isSubject = null;
        SubjectEntity subject = new SubjectEntity(title);
        if (id != null) {
            isSubject = subjectRepository.findById(id);
            subject.setSubject(isSubject.get());
        }

        return subjectRepository.save(subject);
    }

    public SubjectEntity updateSubject(String title, Integer subjectCode, Integer id) {
        Optional<SubjectEntity> existSubject = subjectRepository.findById(id);
        Optional<SubjectEntity> isSubject = subjectRepository.findById(subjectCode);
        if (existSubject.isPresent()) {
            SubjectEntity subject = new SubjectEntity(title);
            subject.setId(existSubject.get().getId());
            subject.setSubject(isSubject.get());
            return subjectRepository.save(subject);
        }
        return null;
    }

    public Integer deleteSubject(Integer id) {
        Optional<SubjectEntity> subject = subjectRepository.findById(id);
        if (subject.isPresent()) {
            subjectRepository.delete(subject.get());
            return 1;
        } else return 0;
    }
}