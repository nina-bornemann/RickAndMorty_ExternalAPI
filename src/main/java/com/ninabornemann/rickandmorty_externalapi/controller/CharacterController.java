package com.ninabornemann.rickandmorty_externalapi.controller;

import com.ninabornemann.rickandmorty_externalapi.model.CharacterResults;
import com.ninabornemann.rickandmorty_externalapi.service.CharacterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/character")
public class CharacterController {

    private final CharacterService service;

    public CharacterController(CharacterService service) {
        this.service = service;
    }

    @GetMapping
    public List<CharacterResults> getAllCharacters() {
        return service.getAllCharacters();
    }

    @GetMapping("/{id}")
    public CharacterResults getCharacterById(@PathVariable Integer id) {
        return service.getCharacterById(id);
    }
}
