package com.ninabornemann.rickandmorty_externalapi.controller;

import com.ninabornemann.rickandmorty_externalapi.service.CharacterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/species-statistics")
public class SpeciesStatsController {

    private final CharacterService service;

    public SpeciesStatsController(CharacterService service) {
        this.service = service;
    }


    @GetMapping()
    public int getAliveCharactersBySpecies(@RequestParam String species) {
        return service.getCharacters(Optional.of("alive"), Optional.of(species))
                .size();
    }
}
