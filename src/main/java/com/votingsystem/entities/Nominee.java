package com.votingsystem.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Nominee")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Nominee {

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "award_id")
    private AwardCategory awardCategory;

    @OneToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
}
