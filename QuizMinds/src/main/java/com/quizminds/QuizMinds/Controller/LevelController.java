package com.quizminds.QuizMinds.Controller;

import com.quizminds.QuizMinds.Model.DTO.LevelDTO;
import com.quizminds.QuizMinds.Model.DTO.Resp.LevelRespDTO;
import com.quizminds.QuizMinds.Model.Entity.LevelEntity;
import com.quizminds.QuizMinds.Service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/level")
public class LevelController {

    @Autowired
    private LevelService levelService;

    @PostMapping(path = "/insert")
    public LevelRespDTO createLevel(@RequestBody LevelEntity level) {
        return levelService.createLevel(level);
    }


    @PutMapping("/update/{id}")
    public LevelRespDTO updateLevel(@PathVariable Integer id, @RequestBody LevelEntity level) {
        return levelService.updateLevel(level, id);
    }

    @GetMapping(path = "/getall")
    public List<LevelDTO> getLevels() {
        return this.levelService.getLevels();
    }


    @GetMapping("/getone/{id}")
    public ResponseEntity getLevel(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        Optional<LevelDTO> levelRespDTO = Optional.of(levelService.getLevel(id));
        if (levelRespDTO.isPresent()) {
            result.put("level", levelRespDTO.get());
            return ResponseEntity.status(200).body(result);
        }
        result.put("message", "Level Not Found");
        return ResponseEntity.status(404).body(result);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteLevel(@PathVariable Integer id) {
        return this.levelService.deleteLevel(id);
    }

}