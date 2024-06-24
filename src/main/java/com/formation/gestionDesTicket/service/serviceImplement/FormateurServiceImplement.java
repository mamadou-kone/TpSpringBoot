package com.formation.gestionDesTicket.service.serviceImplement;

import com.formation.gestionDesTicket.model.Formateur;
import com.formation.gestionDesTicket.repository.FormateurRepository;
import com.formation.gestionDesTicket.service.FormateurService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Data

public class FormateurServiceImplement implements FormateurService {
    private final FormateurRepository formateurRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public Formateur creer(Formateur formateur) {
        formateur.setMdp(passwordEncoder.encode(formateur.getMdp()));
        return formateurRepository.save(formateur);
    }

    @Override
    public List<Formateur> lire() {
        return formateurRepository.findAll();
    }

    @Override
    public Formateur modifier(Long idFormateur, Formateur formateur) {
        return formateurRepository.findById(idFormateur)
                .map(f->{
                    f.setNom(f.getNom());
                    f.setPrenom(f.getPrenom());
                    f.setEmail(f.getEmail());
                    f.setMdp(passwordEncoder.encode(f.getMdp()));
                    return formateurRepository.save(f);
                }).orElseThrow(()->new RuntimeException("Formateur introuvable"));
    }

    @Override
    public String supprimer(Long idFormateur) {
        formateurRepository.deleteById(idFormateur);
        return "Formateur supprimer";
    }
}
