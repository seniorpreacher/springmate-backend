package com.codecool.springmate.repository;

import com.codecool.springmate.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}