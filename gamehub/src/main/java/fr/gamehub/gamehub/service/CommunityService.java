package fr.gamehub.gamehub.service;

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

    public boolean isMemberOfCommunity(Long userId, Long communityId) {
        // Implémentation basique : Vérifiez si l'utilisateur fait partie des membres de la communauté
        Community community = communityRepository.findById(communityId)
                .orElseThrow(() -> new IllegalArgumentException("Communauté introuvable"));
    
        return community.getMembers().stream()
                .anyMatch(member -> member.getId().equals(userId));
    }
    
}
