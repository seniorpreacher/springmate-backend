package com.codecool.askmate.service;

import com.codecool.askmate.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QuestionService {

    Question save(Question question);

    Optional<Question> find(UUID id);

    List<Question> findAll();

    List<Question> findAll(Sort sort);

    Page<Question> findAll(Pageable pageable);

    void delete(UUID id);

    void delete(Question question);

    void deleteAll();

    long count();

}