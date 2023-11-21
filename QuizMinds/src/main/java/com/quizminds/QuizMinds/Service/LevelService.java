package com.quizminds.QuizMinds.Service;

import com.quizminds.QuizMinds.Exeptions.NotFoundExeption;
import com.quizminds.QuizMinds.Model.DTO.LevelDTO;
import com.quizminds.QuizMinds.Model.DTO.Resp.LevelRespDTO;
import com.quizminds.QuizMinds.Model.Entity.LevelEntity;
import com.quizminds.QuizMinds.Model.Enum.Level;
import com.quizminds.QuizMinds.Repository.LevelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LevelService {
    @Autowired
    private LevelRepository levelRepository;

    @Autowired
    private ModelMapper modelMapper;

    public LevelDTO getLevel(Integer id) {
        return modelMapper.map(levelRepository.findById(id).orElse(null), LevelDTO.class);
    }

    public List<LevelDTO> getLevels() {
        return levelRepository.findAll().stream().map(levelEntity -> modelMapper.map(levelEntity, LevelDTO.class)).collect(Collectors.toList());
    }


    public LevelRespDTO createLevel(LevelEntity level) {
        return modelMapper.map(levelRepository.save(level), LevelRespDTO.class);
    }


    public LevelRespDTO updateLevel(LevelEntity level, Integer id) {
        Optional<LevelEntity> existLevel = levelRepository.findById(id);
        if (existLevel.isPresent()) {
            level.setId(existLevel.get().getId());
            return modelMapper.map(levelRepository.save(level), LevelRespDTO.class);
        }
        return null;
    }


    public String deleteLevel(Integer id) {
        Optional<LevelEntity> level = this.levelRepository.findById(id);
        if (level.isPresent()) {
            levelRepository.deleteById(level.get().getId());
            return "level with id " + id + " deleted successfully";
        }
        return "level with id " + id + " not found";
    }

}
