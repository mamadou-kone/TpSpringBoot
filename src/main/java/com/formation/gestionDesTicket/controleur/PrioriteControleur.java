package com.formation.gestionDesTicket.controleur;

import com.formation.gestionDesTicket.model.Priorite;
import com.formation.gestionDesTicket.service.PrioritieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/priorite")
@Data
@Tag(name = "PrioriteTicket",description = "priorités des tickets")
public class PrioriteControleur {
    private final PrioritieService prioritieService;
    @Operation(summary = "CreationPriorite",description = "Création des nouvelle priorité")
    @PostMapping("/ajouterPriorite")
    public Priorite creerPrio(@RequestBody Priorite priorite){
        return prioritieService.creerPriorite(priorite);
    }
    @Operation(summary = "ListePriorite",description = "La liste des priorités")
    @GetMapping("/listPriorite")
    public List<Priorite>list(){
        return prioritieService.lire();
    }
    @Operation(summary = "modiffierPriorite",description = "Modiffiecation des prioritées")
    @PutMapping("/modiffierPriorite/{id}")
    public Priorite modifPriori(@PathVariable Long id,@RequestBody Priorite priorite){
       return prioritieService.modifPriorite(id,priorite);

    }
    @Operation(summary = "SupprimerPriorite",description = "")
    @DeleteMapping("/supprimerPriorite")
    public String supprPriorite(@PathVariable Long id){
        prioritieService.supprimPriorite(id);
        return "priorité supprimée";
    }
}
