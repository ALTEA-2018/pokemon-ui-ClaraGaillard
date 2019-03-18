package com.miage.altea.tp.pokemon_ui.pokemonTypes.service;

import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.Trainer;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public interface TrainerService {
    List<Trainer> listTrainers();
    void setRestTemplate(RestTemplate restTemplate);
    void setTrainerServiceUrl(String trainerServiceUrl);
}
