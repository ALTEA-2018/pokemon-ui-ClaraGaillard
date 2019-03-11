package com.miage.altea.tp.pokemon_ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/registerTrainer")
    public ModelAndView registerNewTrainer(@RequestBody  String trainerName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", trainerName);
        modelAndView.setViewName("register");
        return modelAndView;
    }
}
