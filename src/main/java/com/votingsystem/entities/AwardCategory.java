package com.votingsystem.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "AwardCategory")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AwardCategory {

    @Id
    @Column(name = "award_id")
    private Integer awardId;

    private String name;
    private String description;
}
