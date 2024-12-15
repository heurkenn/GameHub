package fr.gamehub.gamehub.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gamehub.gamehub.model.Platform;
import fr.gamehub.gamehub.repository.PlatformRepository;

@Service
public class PlatformService {

    @Autowired
    private PlatformRepository platformRepository;

    /**
     * Récupère toutes les plateformes.
     *
     * @return liste de toutes les plateformes
     */
    public List<Platform> findAllPlatforms() {
        return platformRepository.findAll();
    }
    
    public List<Platform> findPlatformsByName(List<String> platformNames) {
        return platformRepository.findByNameIn(platformNames);
    }
    
    public Set<Platform> findAllByIds(List<Long> ids) {
    return new HashSet<>(platformRepository.findAllById(ids));
    }

    

    public List<Platform> findAll() {
        return platformRepository.findAll();
    }

}
