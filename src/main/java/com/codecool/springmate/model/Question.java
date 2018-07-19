package com.codecool.springmate.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Question {

    @Id
    @Getter
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    @Getter
    @CreationTimestamp
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date submissionTime;

    @Getter
    @UpdateTimestamp
    @Column(insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateTime;

    @Getter
    @Setter
    @NotBlank
    @NonNull
    @Column(nullable = false)
    private String title;

    @Getter
    @Setter
    @NotBlank
    @NonNull
    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;

    @Getter
    @Setter
    @Column
    private String imagePath;

    @Getter
    @Formula("(SELECT SUM(rating.value) FROM rating WHERE rating.question_id = id)")
    private Integer rating;
}
