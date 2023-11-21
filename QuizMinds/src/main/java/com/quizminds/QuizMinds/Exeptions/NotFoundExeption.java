package com.quizminds.QuizMinds.Exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundExeption extends RuntimeException {
    public NotFoundExeption(String exeption) {
        super(exeption);
    }
}
