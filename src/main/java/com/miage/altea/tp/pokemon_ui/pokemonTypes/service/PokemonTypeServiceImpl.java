package com.miage.altea.tp.pokemon_ui.pokemonTypes.service;

import com.miage.altea.tp.pokemon_ui.config.RestConfiguration;
import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {

    PokemonTypeServiceImpl() {
    }


    String pokemonServiceUrl;

    String base_url = "/pokemon-types/";

    RestTemplate rT;

    @Override
    public List<PokemonType> listPokemonsTypes() {
        var headers = new HttpHeaders();
        headers.setAcceptLanguageAsLocales(List.of(LocaleContextHolder.getLocale()));
        var httpRequest = new HttpEntity<>(headers);
        PokemonType[] listPoke;
        listPoke = rT.getForObject(this.pokemonServiceUrl+this.base_url, PokemonType[].class, httpRequest);
        List<PokemonType> listPT = Arrays.asList(listPoke);
        return listPT;
    }

    @Autowired
    @Override
    public void setRestTemplate(RestTemplate restTemplate) {
        rT= restTemplate;
    }

    @Override
    @Value("${pokemonType.service.url}")
    public void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.pokemonServiceUrl= pokemonServiceUrl;
    }
}