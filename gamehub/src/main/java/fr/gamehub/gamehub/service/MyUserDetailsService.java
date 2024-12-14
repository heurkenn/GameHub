package fr.gamehub.gamehub.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.gamehub.gamehub.model.User;
import fr.gamehub.gamehub.model.Admin;
import fr.gamehub.gamehub.repository.UserRepository;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository; // votre repository pour charger l'utilisateur

    @Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // Charger l'utilisateur depuis la base de données
    User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé : " + username));

    // Construire la liste des autorités (rôles)
    List<GrantedAuthority> authorities = new ArrayList<>();

    // Ajouter un rôle par défaut pour tous les utilisateurs
    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

    // Vérifier si l'utilisateur est un Admin
    if (user instanceof Admin admin) {
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        if (admin.isSuperAdmin()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_SUPER_ADMIN"));
        }
    }

    // Retourner un objet UserDetails pour Spring Security
    return org.springframework.security.core.userdetails.User.builder()
            .username(user.getUsername())
            .password(user.getPassword())
            .authorities(authorities) // Liste des rôles
            .build();
}

}
