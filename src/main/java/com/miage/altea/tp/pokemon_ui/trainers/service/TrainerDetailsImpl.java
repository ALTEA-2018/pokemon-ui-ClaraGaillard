package com.miage.altea.tp.pokemon_ui.trainers.service;

import com.miage.altea.tp.pokemon_ui.trainers.bo.Trainer;
import com.miage.altea.tp.pokemon_ui.trainers.bo.TrainerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TrainerDetailsImpl implements UserDetailsService {

    @Autowired
    TrainerService trainerService;

    public void setTrainerService(TrainerService trainer){
        trainerService = trainer;
    }

    public TrainerService getTrainerService(){
        return trainerService;
    }

    @Override
    public TrainerDetails loadUserByUsername(String s) throws UsernameNotFoundException, BadCredentialsException {
        TrainerDetails trainerDetails = new TrainerDetails();
        Trainer trainer = trainerService.getTrainer(s);
        if(trainer != null) {
            trainerDetails.setTrainer(trainer);
            return trainerDetails;
        }else {
            throw new BadCredentialsException("No such user");
        }
    }
}