package fr.gamehub.gamehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gamehub.gamehub.model.AppUser;
import fr.gamehub.gamehub.repository.AppUserRepository;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository userRepository;

    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    public AppUser saveUser(AppUser user) {
        return userRepository.save(user);
    }
}
