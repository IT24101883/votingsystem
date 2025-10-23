package com.votingsystem.controllers;

import com.votingsystem.entities.User;
import com.votingsystem.services.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService service;
    public UserController(UserService service){ this.service = service; }

    @GetMapping
    public List<User> all(){ return service.getAll(); }

    @GetMapping("/{id}")
    public Optional<User> get(@PathVariable Integer id){ return service.getById(id); }

    @PostMapping
    public User create(@RequestBody User u){ return service.create(u); }

    @PutMapping("/{id}")
    public User update(@PathVariable Integer id, @RequestBody User u){ return service.update(id,u); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){ service.delete(id); }
}
