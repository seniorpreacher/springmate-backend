package com.codecool.springmate.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Rating {

    @Id
    @Getter
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    @Getter
    @CreationTimestamp
    @Column(insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date submissionTime;

    @Getter
    @Setter
    @NonNull
    @Column(nullable = false)
    private Integer value;

    @NonNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "question_id")
    private Question question;
}
