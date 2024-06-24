package com.formation.gestionDesTicket.controleur;

import com.formation.gestionDesTicket.model.Admin;
import com.formation.gestionDesTicket.model.Reponse;
import com.formation.gestionDesTicket.service.AdminService;
import com.formation.gestionDesTicket.service.ReponseService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reponse")
@Data
public class ReponseControleur {
    private final ReponseService reponseService;
    @PostMapping("/creationReponse")
    public Reponse creation(@RequestBody Reponse reponse){
        return reponseService.creerReponse(reponse);
    }


    @GetMapping("/Liste")
    public List<Reponse> read(){
        return reponseService.lireReponse();
    }
    @PutMapping("modifier/{id}")
    public Reponse modif(@PathVariable long id,@RequestBody Reponse reponse){
        return reponseService.moddifierReponse(id,reponse);
    }
    @DeleteMapping("/supprimer/{id}")
    public String supprim(@PathVariable long id){
        return reponseService.suppReponse(id);
    }
}
