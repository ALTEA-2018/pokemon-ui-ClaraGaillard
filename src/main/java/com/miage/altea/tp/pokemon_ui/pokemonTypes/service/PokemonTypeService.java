package com.miage.altea.tp.pokemon_ui.pokemonTypes.service;

import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.Pokemon;
import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.PokemonType;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public interface PokemonTypeService {

    List<PokemonType> listPokemonsTypes();
    void setRestTemplate(RestTemplate restTemplate);
    void setPokemonTypeServiceUrl(String pokemonServiceUrl);
    PokemonType getPokemonType(int id);
}