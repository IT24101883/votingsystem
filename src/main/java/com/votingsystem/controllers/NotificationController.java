package com.votingsystem.controllers;

import com.votingsystem.entities.Notification;
import com.votingsystem.entities.User;
import com.votingsystem.services.NotificationService;
import com.votingsystem.services.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = "*")
public class NotificationController {
    private final NotificationService service;
    private final UserService userService;

    public NotificationController(NotificationService service, UserService userService){
        this.service = service;
        this.userService = userService;
    }

    @GetMapping
    public List<Notification> all(){ return service.getAll(); }

    @GetMapping("/{id}")
    public Optional<Notification> get(@PathVariable Integer id){ return service.getById(id); }

    @PostMapping
    public Notification create(@RequestBody Notification n){ return service.create(n); }

    @PutMapping("/{id}")
    public Notification update(@PathVariable Integer id, @RequestBody Notification n){ return service.update(id,n); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){ service.delete(id); }

    @GetMapping("/user/{userId}")
    public List<Notification> byUser(@PathVariable Integer userId){
        Optional<User> u = userService.getById(userId);
        return u.map(user -> service.findByUser(user)).orElse(List.of());
    }
}
