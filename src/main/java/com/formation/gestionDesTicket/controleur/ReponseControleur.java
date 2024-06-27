package com.formation.gestionDesTicket.controleur;

import com.formation.gestionDesTicket.model.Admin;
import com.formation.gestionDesTicket.model.Reponse;
import com.formation.gestionDesTicket.service.AdminService;
import com.formation.gestionDesTicket.service.ReponseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reponse")
@Data
@Tag(name = "ReponseTicket", description = "reponse aux tickets")
public class ReponseControleur {
    private final ReponseService reponseService;
    @Operation(summary = "CreerReponse", description = "création des reposes")
    @PostMapping("/creationReponse/{id}")
    public Reponse creation(@PathVariable Long id,@RequestBody Reponse reponse){
        return reponseService.creerReponse(id,reponse);
    }

@Operation(summary = "ListeRepose",description = "la liste des reponses")
    @GetMapping("/Liste")
    public List<Reponse> read(){
        return reponseService.lireReponse();
    }
    @Operation(summary = "ModifierReponse",description = "modification des reponse")
    @PutMapping("modifier/{id}")
    public Reponse modif(@PathVariable long id,@RequestBody Reponse reponse){
        return reponseService.moddifierReponse(id,reponse);
    }
    @Operation(summary = "SupprimerReponse",description = "Suppresion des reponses")
    @DeleteMapping("/supprimer/{id}")
    public String supprim(@PathVariable long id){
        return reponseService.suppReponse(id);
    }
}
