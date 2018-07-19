package com.codecool.askmate.controller;

import com.codecool.askmate.model.Rating;
import com.codecool.askmate.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/rating")
    public Rating save(@RequestBody Rating rating){
        return ratingService.save(rating);
    }

    @GetMapping("/rating/{id}")
    public Optional<Rating> getById(@PathVariable(value = "id") Long id){
        return ratingService.find(id);
    }

    @GetMapping("/rating")
    public List<Rating> getAll(){
        return ratingService.findAll();
    }

    @DeleteMapping("/rating/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        ratingService.delete(id);
    }

    @DeleteMapping("/rating")
    public void deleteAll(){
        ratingService.deleteAll();
    }

    @GetMapping("/rating/count")
    public long count(){
        return ratingService.count();
    }
}