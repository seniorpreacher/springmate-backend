package com.codecool.springmate.service;

import com.codecool.springmate.model.Rating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface RatingService {

    Rating save(Rating rating);

    Optional<Rating> find(Long id);

    List<Rating> findAll();

    List<Rating> findAll(Sort sort);

    Page<Rating> findAll(Pageable pageable);

    void delete(Long id);

    void delete(Rating rating);

    void deleteAll();

    long count();

}