package com.formation.gestionDesTicket.service.serviceImplement;

import com.formation.gestionDesTicket.model.Categorie;
import com.formation.gestionDesTicket.repository.CathegorieRepository;
import com.formation.gestionDesTicket.service.CategorieService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
@Data
@Service
public class CategorieServiceImplement implements CategorieService {
    private final CathegorieRepository cathegorieRepository;
    @Override
    public Categorie creerCategorie(Categorie categorie) {
        return cathegorieRepository.save(categorie);
    }

    @Override
    public List<Categorie> lire() {
        return cathegorieRepository.findAll();
    }

    @Override
    public Categorie modifCategorie(Long idCategorie,Categorie categorie) {
        return cathegorieRepository.findById(idCategorie)
                .map((c)->{
                    c.setNomCategorie(c.getNomCategorie());
                    return cathegorieRepository.save(c);
                }).orElseThrow(()->new RuntimeException("Categorie non trouvée"));
    }

    @Override
    public String supprimCategorie(Long idCategorie) {
        cathegorieRepository.deleteById(idCategorie);
        return "Categorie Supprimée";
    }
}
