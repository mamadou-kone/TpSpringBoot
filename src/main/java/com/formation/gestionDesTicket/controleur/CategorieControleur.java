package com.formation.gestionDesTicket.controleur;

import com.formation.gestionDesTicket.model.Categorie;
import com.formation.gestionDesTicket.service.CategorieService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorie")
@Data
public class CategorieControleur {
    private final CategorieService categorieService;
    @PostMapping("/creerCategorie")
    public Categorie creer(@RequestBody Categorie categorie){
        return categorieService.creerCategorie(categorie);
    }
    @GetMapping("/listCategorie")
    public List<Categorie>lire(){
        return categorieService.lire();
    }
    @PutMapping("/modifierCategorie/{id}")
    public Categorie modifCategorie(@PathVariable Long id,@RequestBody Categorie categorie){
        return categorieService.modifCategorie(id,categorie);
    }

    @DeleteMapping("/supprCategorie/{id}")
    public String supprCategorie(@PathVariable Long id){
        return categorieService.supprimCategorie(id);
    }

}
