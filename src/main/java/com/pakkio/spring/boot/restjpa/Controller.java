package com.pakkio.spring.boot.restjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class Controller {

    @Autowired
    ArticoloRepository repo;

    // Get a Single Note
    @GetMapping("/art/{id}")
    public ResponseEntity<Articolo> getArticolo(
            @RequestHeader("processid") String processId,
            @PathVariable(value = "id") Long id) {
        Articolo art = repo.findOne(id);
        if (art == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(art);
    }

}

