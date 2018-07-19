package com.codecool.askmate.service;

import com.codecool.askmate.model.Rating;
import com.codecool.askmate.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating save(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Optional<Rating> find(Long id) {
        return ratingRepository.findById(id);
    }

    @Override
    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> findAll(Sort sort){
        return ratingRepository.findAll(sort);
    }

    @Override
    public Page<Rating> findAll(Pageable pageable){
        return ratingRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
    ratingRepository.deleteById(id);
    }

    @Override
    public void delete(Rating rating) {
        ratingRepository.delete(rating);
    }

    @Override
    public void deleteAll() {
        ratingRepository.deleteAll();
    }

    @Override
    public long count() {
        return ratingRepository.count();
    }

}