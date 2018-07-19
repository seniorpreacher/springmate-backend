package com.codecool.springmate.controller;

import com.codecool.springmate.model.Question;
import com.codecool.springmate.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/question")
    public Question save(
            @Valid @RequestBody Question question) {
        return questionService.save(question);
    }

    @GetMapping("/question/{id}")
    public Optional<Question> getById(@PathVariable(value = "id") UUID id) {
        return questionService.find(id);
    }

    @PutMapping("/question/{id}")
    public Optional<Question> updateById(
            @PathVariable(value = "id") UUID id,
            @Valid @RequestBody Question question) {
        Optional<Question> optionalQuestion = questionService.find(id);
        if (optionalQuestion.isPresent()) {
            Question q = optionalQuestion.get();
            q.setTitle(question.getTitle());
            q.setMessage(question.getMessage());
            questionService.save(q);
            return Optional.of(q);
        }

        return optionalQuestion;
    }

    @GetMapping("/question")
    public List<Question> getAll() {
        return questionService.findAll();
    }

    @DeleteMapping("/question/{id}")
    public void deleteById(@PathVariable(value = "id") UUID id) {
        questionService.delete(id);
    }

    @DeleteMapping("/question")
    public void deleteAll() {
        questionService.deleteAll();
    }

    @GetMapping("/question/count")
    public long count() {
        return questionService.count();
    }
}
