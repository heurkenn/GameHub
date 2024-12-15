package fr.gamehub.gamehub.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.gamehub.gamehub.model.User;
import fr.gamehub.gamehub.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Récupère un utilisateur par son ID
     *
     * @param id L'ID de l'utilisateur
     * @return Un Optional contenant l'utilisateur ou vide s'il n'existe pas
     */
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Enregistre ou met à jour un utilisateur
     *
     * @param user L'utilisateur à sauvegarder
     * @return L'utilisateur sauvegardé
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Récupère un utilisateur par email
     *
     * @param email L'email de l'utilisateur
     * @return Un Optional contenant l'utilisateur ou vide s'il n'existe pas
     */
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Récupère un utilisateur par nom d'utilisateur
     *
     * @param username Le nom d'utilisateur
     * @return Un Optional contenant l'utilisateur ou vide s'il n'existe pas
     */
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Récupère un utilisateur par nom d'utilisateur
     *
     * @param id Le nom d'utilisateur
     * @return Un Optional contenant l'utilisateur ou vide s'il n'existe pas
     */
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Récupère tous les utilisateurs
     *
     * @return Une liste de tous les utilisateurs
     */
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }


    /**
     * Encode un mot de passe.
     *
     * @param rawPassword Le mot de passe brut
     * @return Le mot de passe encodé
     */
    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }
    public List<User> findAllUsersWithRole(String role) {
        return userRepository.findAll().stream()
                .filter(user -> user.getRoles().contains(role))
                .collect(Collectors.toList());
    }
}
