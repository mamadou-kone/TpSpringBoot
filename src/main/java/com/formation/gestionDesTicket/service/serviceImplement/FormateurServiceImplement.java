package com.formation.gestionDesTicket.service.serviceImplement;

import com.formation.gestionDesTicket.Mail.Messagerie;
import com.formation.gestionDesTicket.model.Formateur;
import com.formation.gestionDesTicket.repository.FormateurRepository;
import com.formation.gestionDesTicket.service.FormateurService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Data
@AllArgsConstructor
public class FormateurServiceImplement implements FormateurService {
    private final FormateurRepository formateurRepository;

    PasswordEncoder passwordEncoder;
     private Messagerie message;
    @Override
    public Formateur creer(Formateur form) {
        message.envoiesMessage(form.getEmail(), "Votre compte a été créer avec succès avec comme mot de pass : "+form.getMdp());
        form.setMdp(passwordEncoder.encode(form.getMdp()));
        return formateurRepository.save(form);
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
