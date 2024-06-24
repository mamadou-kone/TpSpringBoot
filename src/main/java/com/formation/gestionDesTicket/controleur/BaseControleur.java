package com.formation.gestionDesTicket.controleur;

import com.formation.gestionDesTicket.model.Base;
import com.formation.gestionDesTicket.service.BaseService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baseConnaissace")
@Data
public class BaseControleur {
    private final BaseService baseService;
    @PostMapping("/ajouterBaseConnaissnce")
    public Base creer(@RequestBody Base base){
        return baseService.creerBase(base);
    }

    @GetMapping ("/listBaseConnaissance")
    public List<Base>lire(){
        return baseService.lire();
    }

    @PutMapping("/modiffierBaseConnaissance")
    public Base modif(@PathVariable Long id,@RequestBody Base base){
        return baseService.modifBase(id,base);
    }
    @DeleteMapping("/supprimerBaseConnaissance/{id}")
    public String supprBase(@PathVariable Long id){
        baseService.supprimBase(id);
        return "base de connaissance supprimée";
    }

}
