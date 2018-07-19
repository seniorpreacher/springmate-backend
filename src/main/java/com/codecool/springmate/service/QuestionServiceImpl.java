package com.codecool.springmate.service;

import com.codecool.springmate.model.Question;
import com.codecool.springmate.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Optional<Question> find(UUID id) {
        return questionRepository.findById(id);
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> findAll(Sort sort) {
        return questionRepository.findAll(sort);
    }

    @Override
    public Page<Question> findAll(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public void delete(UUID id) {
        questionRepository.deleteById(id);
    }

    @Override
    public void delete(Question question) {
        questionRepository.delete(question);
    }

    @Override
    public void deleteAll() {
        questionRepository.deleteAll();
    }

    @Override
    public long count() {
        return questionRepository.count();
    }

}