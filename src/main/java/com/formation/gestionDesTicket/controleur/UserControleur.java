package com.formation.gestionDesTicket.controleur;

import com.formation.gestionDesTicket.model.Utilisateur;
import com.formation.gestionDesTicket.service.UserService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Data
public class UserControleur {
    private final UserService userService;
    @PostMapping("/ajoutUser")
   public Utilisateur creerUser(@RequestBody Utilisateur user){
        return userService.creer(user);
    }
    @GetMapping("/listUser")
    public List<Utilisateur> lire(){
        return userService.lire();
    }
    @PutMapping("/modifierUser")
    public Utilisateur modifuser(@PathVariable Long id, @RequestBody Utilisateur user){
        return userService.modif(id,user);
    }
    @DeleteMapping("/supprimerUser")
    public String suppUser(@PathVariable Long id){
       return userService.supprim(id);
    }

}
