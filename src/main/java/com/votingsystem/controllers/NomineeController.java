package com.votingsystem.controllers;

import com.votingsystem.entities.Nominee;
import com.votingsystem.services.NomineeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nominees")
@CrossOrigin(origins = "*")
public class NomineeController {
    private final NomineeService service;
    public NomineeController(NomineeService service){ this.service = service; }

    @GetMapping
    public List<Nominee> all(){ return service.getAll(); }

    @GetMapping("/{id}")
    public Optional<Nominee> get(@PathVariable Integer id){ return service.getById(id); }

    @PostMapping
    public Nominee create(@RequestBody Nominee n){ return service.create(n); }

    @PutMapping("/{id}")
    public Nominee update(@PathVariable Integer id, @RequestBody Nominee n){ return service.update(id,n); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){ service.delete(id); }
}
