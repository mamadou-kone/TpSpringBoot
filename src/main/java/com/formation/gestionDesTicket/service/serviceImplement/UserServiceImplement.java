package com.formation.gestionDesTicket.service.serviceImplement;

import com.formation.gestionDesTicket.model.Utilisateur;
import com.formation.gestionDesTicket.repository.UserRepository;
import com.formation.gestionDesTicket.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class UserServiceImplement implements UserService {
    private final UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public Utilisateur creer(Utilisateur user) {
        user.setMdp(passwordEncoder.encode(user.getMdp()));
        return userRepository.save(user);
    }

    @Override
    public List<Utilisateur> lire() {
        return userRepository.findAll();
    }

    @Override
    public Utilisateur modif(Long id, Utilisateur user) {
        return userRepository.findById(id)
                .map((u)->{
                    u.setNom(u.getNom());
                    u.setPrenom(u.getPrenom());
                    u.setMdp(passwordEncoder.encode(u.getMdp()));
                    u.setRole(u.getRole());
                   return userRepository.save(u);
                }).orElseThrow(()->new RuntimeException("USER NON TROUVE"));
    }

    @Override
    public String supprim(Long id) {
        userRepository.deleteById(id);
        return "USER SUPPRIME";
    }
}
