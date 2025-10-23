package com.votingsystem.services;

import com.votingsystem.entities.User;
import com.votingsystem.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repo;
    public UserService(UserRepository repo){ this.repo = repo; }

    public List<User> getAll() { return repo.findAll(); }
    public Optional<User> getById(Integer id) { return repo.findById(id); }
    public User create(User u) { return repo.save(u); }
    public User update(Integer id, User u){
        return repo.findById(id).map(existing -> {
            existing.setName(u.getName());
            existing.setEmail(u.getEmail());
            existing.setPassword(u.getPassword());
            existing.setRole(u.getRole());
            return repo.save(existing);
        }).orElse(null);
    }
    public void delete(Integer id) { repo.deleteById(id); }
    public Optional<User> findByEmail(String email){ return repo.findByEmail(email); }
}
