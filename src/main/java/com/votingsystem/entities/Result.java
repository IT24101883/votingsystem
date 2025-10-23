package com.votingsystem.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Result")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Result {

    @Id
    @Column(name = "result_id")
    private Integer resultId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "award_id", nullable = false, referencedColumnName = "award_id")
    private AwardCategory awardCategory;

    // nominee_id references Nominee.user_id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nominee_id", nullable = false, referencedColumnName = "user_id")
    private Nominee nominee;

    @Column(name = "total_votes", nullable = false)
    private Integer totalVotes;
}
