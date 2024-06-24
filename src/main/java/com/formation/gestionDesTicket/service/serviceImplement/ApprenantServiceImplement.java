package com.formation.gestionDesTicket.service.serviceImplement;

import com.formation.gestionDesTicket.model.Apprenant;
import com.formation.gestionDesTicket.repository.AprenantRepository;
import com.formation.gestionDesTicket.service.ApprenantService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ApprenantServiceImplement implements ApprenantService{
    private final AprenantRepository aprenantRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public Apprenant creer(Apprenant apprenant) {
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
