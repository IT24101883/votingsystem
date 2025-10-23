package com.votingsystem.controllers;

import com.votingsystem.entities.Result;
import com.votingsystem.services.ResultService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/results")
@CrossOrigin(origins = "*")
public class ResultController {
    private final ResultService service;
    public ResultController(ResultService service){ this.service = service; }

    @GetMapping
    public List<Result> all(){ return service.getAll(); }

    @GetMapping("/{id}")
    public Optional<Result> get(@PathVariable Integer id){ return service.getById(id); }

    @PostMapping
    public Result create(@RequestBody Result r){ return service.create(r); }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody Result r){ return service.update(id,r); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){ service.delete(id); }
}
