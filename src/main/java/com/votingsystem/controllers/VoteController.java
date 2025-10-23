package com.votingsystem.controllers;

import com.votingsystem.entities.Vote;
import com.votingsystem.entities.User;
import com.votingsystem.entities.Nominee;
import com.votingsystem.services.VoteService;
import com.votingsystem.services.UserService;
import com.votingsystem.services.NomineeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/votes")
@CrossOrigin(origins = "*")
public class VoteController {
    private final VoteService voteService;
    private final UserService userService;
    private final NomineeService nomineeService;

    public VoteController(VoteService voteService, UserService userService, NomineeService nomineeService){
        this.voteService = voteService;
        this.userService = userService;
        this.nomineeService = nomineeService;
    }

    @GetMapping
    public List<com.votingsystem.entities.Vote> all(){ return voteService.getAll(); }

    @GetMapping("/{id}")
    public Optional<com.votingsystem.entities.Vote> get(@PathVariable Integer id){ return voteService.getById(id); }

    @PostMapping
    public Object create(@RequestBody Vote v){
        // Basic duplicate-check example: prevent same voter voting same nominee twice
        if (v.getVoter() == null || v.getNominee() == null) return "voter and nominee required";
        Optional<User> voter = userService.getById(v.getVoter().getUserId());
        Optional<Nominee> nominee = nomineeService.getById(v.getNominee().getUserId());
        if (voter.isEmpty() || nominee.isEmpty()) return "voter or nominee not found";

        if (voteService.findByVoterAndNominee(voter.get(), nominee.get()).isPresent()){
            return "duplicate";
        }
        v.setVoter(voter.get());
        v.setNominee(nominee.get());
        return voteService.create(v);
    }

    @PutMapping("/{id}")
    public Vote update(@PathVariable Integer id, @RequestBody Vote v){ return voteService.update(id, v); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){ voteService.delete(id); }

    @GetMapping("/by-voter/{userId}")
    public List<com.votingsystem.entities.Vote> byVoter(@PathVariable Integer userId){
        Optional<User> u = userService.getById(userId);
        return u.map(user -> voteService.findByVoter(user)).orElse(List.of());
    }
}
