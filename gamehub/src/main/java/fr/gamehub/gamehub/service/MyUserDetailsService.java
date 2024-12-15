package fr.gamehub.gamehub.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.gamehub.gamehub.model.User;
import fr.gamehub.gamehub.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Charger l'utilisateur depuis la base de données
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé : " + username));

        // Initialiser explicitement les rôles pour éviter LazyInitializationException
        user.getRoles().size();

        // Affichage des rôles pour vérifier ce qui est chargé
        System.out.println("Rôles chargés pour l'utilisateur " + username + " : " + user.getRoles());

        // Construire la liste des autorités (rôles)
        List<GrantedAuthority> authorities = user.getRoles().stream()
            .map(SimpleGrantedAuthority::new) // Utilisation directe sans conflit
            .collect(Collectors.toList());    // Assurez-vous d'utiliser Collectors.toList()

        // Retourner un objet UserDetails pour Spring Security
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(authorities) // Liste des rôles
                .build();
    }
}
