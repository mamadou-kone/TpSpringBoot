package com.formation.gestionDesTicket.service.serviceImplement;

import com.formation.gestionDesTicket.Mail.Messagerie;
import com.formation.gestionDesTicket.model.Base;
import com.formation.gestionDesTicket.model.Formateur;
import com.formation.gestionDesTicket.model.Utilisateur;
import com.formation.gestionDesTicket.repository.BaseRepository;
import com.formation.gestionDesTicket.repository.UserRepository;
import com.formation.gestionDesTicket.securiteConfig.SessionUser;
import com.formation.gestionDesTicket.securiteConfig.securiteConfiguration;
import com.formation.gestionDesTicket.service.BaseService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
@AllArgsConstructor
public class BaseServiceImplement implements BaseService {
    private final BaseRepository baseRepository;
@Autowired
    private SessionUser sessionUser;
    private UserRepository userRepository;
    private Messagerie messagerie;
    @Override
    public Base creerBase(Base base) {
        Optional<Utilisateur> utilisateur=sessionUser.getAuthenticatedUser();
        base.setFormateur((Formateur) utilisateur.get());
        return baseRepository.save(base);
    }

    @Override
    public List<Base> lire() {
        return baseRepository.findAll();
    }

    @Override
    public Base modifBase(Long idBase, Base base) {
        return baseRepository.findById(idBase)
                .map((b)->{
                  b.setNomBase(b.getNomBase());
                  b.setLien(b.getLien());
                    return baseRepository.save(b);
                }).orElseThrow(()->new RuntimeException("Base non Trouvée"));
    }

    @Override
    public String supprimBase(Long idBase) {
        baseRepository.deleteById(idBase);
        return "Base supprimer";
    }


}
