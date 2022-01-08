package com.backend.lmsapi.controllers;

import com.backend.lmsapi.dto.GenreDto;
import com.backend.lmsapi.dto.ResponseGenre;
import com.backend.lmsapi.services.GenreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping()
    public ResponseEntity<?> getAllGenre(){
        return new ResponseEntity<>(genreService.getAllGenre(), HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<?> getGenre(@RequestParam String id) {
        return new ResponseEntity<>(genreService.getGenre(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> addGenre(@RequestBody GenreDto genreDto) {
        return new ResponseEntity<>(genreService.addGenre(genreDto), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<?> updateGenre(@RequestBody ResponseGenre responseGenre) {
        return new ResponseEntity<>(genreService.updateGenre(responseGenre), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteGenre(@RequestParam String id){
        return new ResponseEntity<>(genreService.deleteGenre(id), HttpStatus.OK);
    }
}
