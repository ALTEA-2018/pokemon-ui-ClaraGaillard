package com.miage.altea.tp.pokemon_ui.trainers.service;

import com.miage.altea.tp.pokemon_ui.trainers.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TrainerServiceImpl implements TrainerService{

    String trainerServiceUrl;

    String base_url = "/trainers/";

    RestTemplate restTemplate;

    @Override
    @Cacheable(value = "trainers")
    public List<Trainer> listTrainers() {
        var headers = new HttpHeaders();
        headers.setAcceptLanguageAsLocales(List.of(LocaleContextHolder.getLocale()));
        var httpRequest = new HttpEntity<>(headers);
        Trainer[] listTrainers;
        listTrainers = restTemplate.getForObject(this.trainerServiceUrl+this.base_url, Trainer[].class, httpRequest);
        List<Trainer> listT = Arrays.asList(listTrainers);
        return listT;
    }

    @Autowired
    @Override
    @Qualifier("trainerApiRestTemplate")
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @Value("${trainer.service.url}")
    public void setTrainerServiceUrl(String trainerServiceUrl) {
        this.trainerServiceUrl= trainerServiceUrl;
    }

    @Override
    public Trainer getTrainer(String name) {

        Trainer trainer;
        trainer = restTemplate.getForObject(this.trainerServiceUrl+this.base_url+"{name}", Trainer.class, name);
        return trainer;

    }
}
