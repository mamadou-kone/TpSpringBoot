package com.formation.gestionDesTicket.controleur;

import com.formation.gestionDesTicket.model.Priorite;
import com.formation.gestionDesTicket.service.PrioritieService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/priorite")
@Data
public class PrioriteControleur {
    private final PrioritieService prioritieService;
    @PostMapping("/ajouterPriorite")
    public Priorite creerPrio(@RequestBody Priorite priorite){
        return prioritieService.creerPriorite(priorite);
    }
    @GetMapping("/listPriorite")
    public List<Priorite>list(){
        return prioritieService.lire();
    }

    @PutMapping("/modiffierPriorite/{id}")
    public Priorite modifPriori(@PathVariable Long id,@RequestBody Priorite priorite){
       return prioritieService.modifPriorite(id,priorite);

    }
    @DeleteMapping("/supprimerPriorite")
    public String supprPriorite(@PathVariable Long id){
        prioritieService.supprimPriorite(id);
        return "priorité supprimée";
    }
}
