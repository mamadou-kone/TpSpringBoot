package com.formation.gestionDesTicket.service.serviceImplement;

import com.formation.gestionDesTicket.model.Priorite;
import com.formation.gestionDesTicket.repository.PrioriteRepository;
import com.formation.gestionDesTicket.service.PrioritieService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
@Data
@Service
public class PrioriteServiceImplement implements PrioritieService {
    private final PrioriteRepository prioriteRepository;
    @Override
    public Priorite creerPriorite(Priorite priorite) {
        return prioriteRepository.save(priorite);
    }

    @Override
    public List<Priorite> lire() {
        return prioriteRepository.findAll();
    }

    @Override
    public Priorite modifPriorite(Long idPriorite, Priorite priorite) {
        return prioriteRepository.findById(idPriorite)
                .map((p)->{
                    p.setNomPriorite(p.getNomPriorite());
                    return prioriteRepository.save(p);

                }).orElseThrow(()->new RuntimeException("Priorite non trouvée"));
    }

    @Override
    public String supprimPriorite(Long idPriorite) {
        prioriteRepository.deleteById(idPriorite);
        return "Prioritie supprimer";
    }
}
