package com.ninabornemann.rickandmorty_externalapi.service;

import com.ninabornemann.rickandmorty_externalapi.model.CharacterResults;
import com.ninabornemann.rickandmorty_externalapi.model.MultiCharacter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class CharacterService {

    private final RestClient restClient;

    public CharacterService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl("https://rickandmortyapi.com/api")
                .build();
    }

    public List<CharacterResults> getAllCharacters() {
        List<CharacterResults> characters =
                restClient.get()
                        .uri("/character")
                        .retrieve()
                        .body(MultiCharacter.class)
                        .results();
        return characters;
    }
}

