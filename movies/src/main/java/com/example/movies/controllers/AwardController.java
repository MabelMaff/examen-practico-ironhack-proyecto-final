package com.example.movies.controllers;

import com.example.movies.models.Award;
import com.example.movies.repositories.AwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/awards")
public class AwardController {

    @Autowired
    private AwardRepository awardRepository;

    @GetMapping
    public List<Award> getAllAwards() {
        return awardRepository.findAll();
    }

    @PostMapping
    public Award createAward(@RequestBody Award award) {
        return awardRepository.save(award);
    }
}
