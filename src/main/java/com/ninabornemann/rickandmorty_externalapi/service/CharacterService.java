package com.ninabornemann.rickandmorty_externalapi.service;

import com.ninabornemann.rickandmorty_externalapi.model.CharacterResults;
import com.ninabornemann.rickandmorty_externalapi.model.MultiCharacter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriUtils;

import java.net.URI;
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

    public CharacterResults getCharacterById(Integer id) {
        return restClient.get()

                .uri("/character/{id}", id)
                .retrieve()
                .body(CharacterResults.class);
    }

    public List<CharacterResults> getCharactersByStatus(String status) {

        return restClient.get()
                .uri(builder -> {
                    return builder.path("/character").
                            queryParam("status", status).
                            build();
                })
                .retrieve()
                .body(MultiCharacter.class)
                .results();

    }
}

