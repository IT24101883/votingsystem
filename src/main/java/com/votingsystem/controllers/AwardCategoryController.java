package com.votingsystem.controllers;

import com.votingsystem.entities.AwardCategory;
import com.votingsystem.services.AwardCategoryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/awardcategories")
@CrossOrigin(origins = "*")
public class AwardCategoryController {
    private final AwardCategoryService service;
    public AwardCategoryController(AwardCategoryService service){ this.service = service; }

    @GetMapping
    public List<AwardCategory> all(){ return service.getAll(); }

    @GetMapping("/{id}")
    public Optional<AwardCategory> get(@PathVariable Integer id){ return service.getById(id); }

    @PostMapping
    public AwardCategory create(@RequestBody AwardCategory a){ return service.create(a); }

    @PutMapping("/{id}")
    public AwardCategory update(@PathVariable Integer id, @RequestBody AwardCategory a){ return service.update(id,a); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){ service.delete(id); }
}
