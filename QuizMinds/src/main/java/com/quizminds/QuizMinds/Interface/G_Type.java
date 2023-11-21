package com.quizminds.QuizMinds.Interface;

import java.util.List;
import java.util.Optional;

public interface G_Type<T, V, R> {
    Optional<R> get(T t);

    R create(T t);

    String delete(T t);

    List<R> getAll();
}
