package fr.gamehub.gamehub.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gamehub.gamehub.model.Fight;
import fr.gamehub.gamehub.repository.FightRepository;


@Service
public class FightService {

    @Autowired
    private FightRepository fightRepository;

    // Ajoute aussi une méthode pour enregistrer ou mettre à jour un tournoi
    public Fight saveFight(Fight fight) {
        return fightRepository.save(fight);
    }

    
}
