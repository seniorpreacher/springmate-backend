package com.codecool.askmate.repository;

import com.codecool.askmate.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}