package com.votingsystem.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Vote")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Vote {

    @Id
    @Column(name = "vote_id")
    private Integer voteId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User voter;

    @ManyToOne
    @JoinColumn(name = "nominee_id")
    private Nominee nominee;

    @Column(name = "vote_time")
    private LocalDateTime voteTime;
}
