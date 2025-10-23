package com.votingsystem.entities;

import com.votingsystem.enums.Role;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "User")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    private Integer userId;

    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
