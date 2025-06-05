package com.example.movies.controllers;

import com.example.movies.models.Director;
import com.example.movies.repositories.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/directors")
public class DirectorController {

    @Autowired
    private DirectorRepository directorRepository;

    @GetMapping
    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Director getDirectorById(@PathVariable Long id) {
        return directorRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Director createDirector(@RequestBody Director director) {
        return directorRepository.save(director);
    }

    @PutMapping("/{id}")
    public Director updateDirector(@PathVariable Long id, @RequestBody Director updatedDirector) {
        Director director = directorRepository.findById(id).orElse(null);
        if (director != null) {
            director.setName(updatedDirector.getName());
            director.setNationality(updatedDirector.getNationality());
            return directorRepository.save(director);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteDirector(@PathVariable Long id) {
        directorRepository.deleteById(id);
    }
}
