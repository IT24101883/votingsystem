package com.votingsystem.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Notification")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Notification {

    @Id
    @Column(name = "notification_id")
    private Integer notificationId;

    private String message;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    private String status; // 'read' or 'unread'

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
