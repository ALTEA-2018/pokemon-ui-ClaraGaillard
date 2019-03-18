package com.miage.altea.tp.pokemon_ui.pokemonTypes.service;

import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.PokemonType;
import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService{

    String trainerServiceUrl;

    String base_url = "/trainers/";

    RestTemplate rT;

    @Override
    public List<Trainer> listTrainers() {
        var headers = new HttpHeaders();
        headers.setAcceptLanguageAsLocales(List.of(LocaleContextHolder.getLocale()));
        var httpRequest = new HttpEntity<>(headers);
        Trainer[] listTrainers;
        listTrainers = rT.getForObject(this.trainerServiceUrl+this.base_url, Trainer[].class, httpRequest);
        List<Trainer> listT = Arrays.asList(listTrainers);
        return listT;
    }

    @Autowired
    @Override
    public void setRestTemplate(RestTemplate restTemplate) {
        rT= restTemplate;
    }

    @Override
    @Value("https://trainer-api-claragaillard.herokuapp.com/")
    public void setTrainerServiceUrl(String pokemonServiceUrl) {
        this.trainerServiceUrl= trainerServiceUrl;
    }
}
