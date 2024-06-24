package com.formation.gestionDesTicket.service.serviceImplement;

import com.formation.gestionDesTicket.model.Base;
import com.formation.gestionDesTicket.repository.BaseRepository;
import com.formation.gestionDesTicket.service.BaseService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
@Data
@Service
public class BaseServiceImplement implements BaseService {
    private final BaseRepository baseRepository;
    @Override
    public Base creerBase(Base base) {
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
