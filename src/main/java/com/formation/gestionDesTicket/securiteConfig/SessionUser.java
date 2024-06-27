package com.formation.gestionDesTicket.securiteConfig;

import com.formation.gestionDesTicket.model.Utilisateur;
import com.formation.gestionDesTicket.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class SessionUser {
    private UserRepository userRepository;
    public Optional<Utilisateur> getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            String email = ((UserDetails) authentication.getPrincipal()).getUsername();
            return (userRepository.findByEmail(email));
        }
        return null;
    }

}
