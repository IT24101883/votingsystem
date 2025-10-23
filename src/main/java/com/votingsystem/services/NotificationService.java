package com.votingsystem.services;

import com.votingsystem.entities.Notification;
import com.votingsystem.entities.User;
import com.votingsystem.repositories.NotificationRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {
    private final NotificationRepository repo;
    public NotificationService(NotificationRepository repo){ this.repo = repo; }

    public List<Notification> getAll() { return repo.findAll(); }
    public Optional<Notification> getById(Integer id) { return repo.findById(id); }
    public Notification create(Notification n) { return repo.save(n); }
    public Notification update(Integer id, Notification n){
        return repo.findById(id).map(existing -> {
            existing.setMessage(n.getMessage());
            existing.setStatus(n.getStatus());
            return repo.save(existing);
        }).orElse(null);
    }
    public void delete(Integer id) { repo.deleteById(id); }

    public List<Notification> findByUserAndStatus(User user, String status){ return repo.findByUser(user); }
    public List<Notification> findByUser(User user){ return repo.findByUser(user); }
}
