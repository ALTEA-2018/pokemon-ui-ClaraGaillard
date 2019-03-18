package com.miage.altea.tp.pokemon_ui.controller;

import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.Trainer;
import com.miage.altea.tp.pokemon_ui.pokemonTypes.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TrainerController {
    TrainerService trainerService;

    @GetMapping(value="/listTrainers")
    public ModelAndView pokedex(){
        ModelAndView model = new ModelAndView();
        List<Trainer> listT = trainerService.listTrainers();
        model.setViewName("listTrainers");
        model.addObject("trainers", listT);
        return model;
    }

    public TrainerService getTrainerServ() {
        return trainerService;
    }

    @Autowired
    public void setTrainerService(TrainerService trainServ) {
        this.trainerService = trainServ;
    }
}
