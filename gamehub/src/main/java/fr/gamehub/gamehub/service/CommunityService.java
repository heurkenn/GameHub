package fr.gamehub.gamehub.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gamehub.gamehub.model.Community;
import fr.gamehub.gamehub.repository.CommunityRepository;

@Service
public class CommunityService {

    @Autowired
    private CommunityRepository communityRepository;

    public Community getCommunityById(Long id) {
        return communityRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Communauté non trouvée"));
    }

    public Optional<Community> findByName(String name) {
        return communityRepository.findByName(name);
    }

    public Optional<Community> findById(Long id) {
        return communityRepository.findById(id);
    }
}
