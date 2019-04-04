package com.miage.altea.tp.pokemon_ui.trainers.bo;

import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.PokemonType;

import java.util.List;

public class Trainer {

    private String name;

    private String password;

    private List<Pokemon> team;

    private List<PokemonType> listPokemonType;

    public Trainer() {
    }

    public Trainer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pokemon> getTeam() {
        return team;
    }

    public void setTeam(List<Pokemon> team) {
        this.team = team;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PokemonType> getListPokemonType(){return this.listPokemonType;}

    public void setListPokemonType(List<PokemonType> listPokemonType) { this.listPokemonType = listPokemonType;}

}
