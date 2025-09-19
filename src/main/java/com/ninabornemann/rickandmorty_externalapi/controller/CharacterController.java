package com.ninabornemann.rickandmorty_externalapi.controller;

import com.ninabornemann.rickandmorty_externalapi.model.CharacterResults;
import com.ninabornemann.rickandmorty_externalapi.model.MultiCharacter;
import com.ninabornemann.rickandmorty_externalapi.service.CharacterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/status")
    public List<CharacterResults> getCharactersByStatus(@RequestParam String status) {
        return  service.getCharactersByStatus(status);
    }

    @GetMapping("/species-statistic")
    public int getAliveCharactersBySpecies(@RequestParam String species) {
        return service.getAliveCharactersBySpecies(species).size();
    }
}
