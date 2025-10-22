package com.votingsystem.controllers;

import com.votingsystem.entities.User;
import com.votingsystem.services.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getAllUsers() { return service.getAllUsers(); }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) { return service.getUserById(id); }

    @PostMapping
    public User createUser(@RequestBody User user) { return service.createUser(user); }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return service.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) { service.deleteUser(id); }
}
