package com.formation.gestionDesTicket.service.serviceImplement;

import com.formation.gestionDesTicket.Mail.Messagerie;
import com.formation.gestionDesTicket.model.Apprenant;
import com.formation.gestionDesTicket.model.Formateur;
import com.formation.gestionDesTicket.model.Utilisateur;
import com.formation.gestionDesTicket.repository.AprenantRepository;
import com.formation.gestionDesTicket.securiteConfig.SessionUser;
import com.formation.gestionDesTicket.service.ApprenantService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class ApprenantServiceImplement implements ApprenantService{
    private final AprenantRepository aprenantRepository;
    private Messagerie messagerie;
    @Autowired
    SessionUser sessionUser;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public Apprenant creer(Apprenant apprenant) {
        Optional<Utilisateur> utilisateur=sessionUser.getAuthenticatedUser();
        apprenant.setFormateur((Formateur) utilisateur.get());
        messagerie.envoiesMessage(apprenant.getEmail(),"Votre compte a été créer avec succès, votre mot de passe est : "+apprenant.getMdp());
        apprenant.setMdp(passwordEncoder.encode(apprenant.getMdp()));
        return aprenantRepository.save(apprenant);
    }

    @Override
    public List<Apprenant> lire() {
        return aprenantRepository.findAll();
    }

    @Override
    public Apprenant modifApprenant(Long idApprenant, Apprenant apprenant) {
        return aprenantRepository.findById(idApprenant)
                .map(A->{
                A.setNom(A.getNom());
                A.setPrenom(A.getPrenom());
                A.setEmail(A.getEmail());
                A.setMdp(passwordEncoder.encode(A.getMdp()));

                    return aprenantRepository.save(A);
                }).orElseThrow(()->new RuntimeException("Apprenant non trouvé"));
    }

    @Override
    public String supprApprenant(Long idApprenant) {
         aprenantRepository.deleteById(idApprenant);
         return "Apprenant supprimer";
    }
}
