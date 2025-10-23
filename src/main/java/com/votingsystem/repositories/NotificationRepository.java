package com.votingsystem.repositories;

import com.votingsystem.entities.Notification;
import com.votingsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findByUserAndStatus(User user, String status);
    List<Notification> findByUser(User user);
}
