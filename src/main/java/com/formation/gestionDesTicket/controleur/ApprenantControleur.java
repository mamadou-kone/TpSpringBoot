package com.formation.gestionDesTicket.controleur;

import com.formation.gestionDesTicket.model.Apprenant;
import com.formation.gestionDesTicket.service.ApprenantService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/apprenant")
public class ApprenantControleur {
    public final ApprenantService apprenantService;
    @PostMapping("/ajoutApprenant")
    public Apprenant creation(@RequestBody Apprenant apprenant){
        return apprenantService.creer(apprenant);
    }

    @GetMapping("/ListeApprenant")
    public List<Apprenant> lire() {
        return apprenantService.lire();
    }
    @PutMapping("/moddifierAprenant/{id}")
    public Apprenant modifApprenant(@PathVariable Long id,@RequestBody Apprenant apprenant){
        return apprenantService.modifApprenant(id,apprenant);
    }
    @DeleteMapping("/supprimerApprenant/{id}")
    public String supprApprenat(@PathVariable Long id){
        return "Apprenant supprimer";
    }
}
