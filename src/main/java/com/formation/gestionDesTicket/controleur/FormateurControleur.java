package com.formation.gestionDesTicket.controleur;

import com.formation.gestionDesTicket.model.Formateur;
import com.formation.gestionDesTicket.service.FormateurService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formateur")
@Data
public class FormateurControleur {
    private final FormateurService formateurService;
    @PostMapping("/creerFormateur")
    public Formateur creation(@RequestBody Formateur formateur){
        return formateurService.creer(formateur);
    }
    @GetMapping("/ListeFormateur")
    public List<Formateur> lire(){
        return formateurService.lire();
    }
    @PutMapping("/modifierFormateur/{id}")
    public Formateur modifFormateur(@PathVariable Long id,@RequestBody Formateur formateur){
        return formateurService.modifier(id,formateur);
    }
    @DeleteMapping("/supprimerFormateur/{id}")
    public String supprimerFormateur (@PathVariable Long id){
        return "Formateur supprimer";
    }

}
