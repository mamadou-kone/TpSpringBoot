package com.formation.gestionDesTicket.controleur;

import com.formation.gestionDesTicket.model.Role;
import com.formation.gestionDesTicket.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("role")
@Tag(name = "RoleUtilisateur", description = "roles attribués aux utilisateur")
public class RoleControleur {
    @Autowired
    private RoleService roleService;
    @Operation(summary = "CreerRole", description = "création des roles")
    @PostMapping("/AjoutRole")
    public Role creerRole(Role role){
        return roleService.creerRole(role);
    }
    @Operation(summary = "ListeRole", description = "liste des roles")
    @GetMapping("/Liste/{id}")
    public List<Role> Liste(Long id){
        return roleService.lire();
    }
    @Operation(summary = "ModifierRole",description = "Modifier les roles")
    @PutMapping("/modifRole/{id}")
    public Role modifRole(@PathVariable Long id,@RequestBody Role role){
        return roleService.modiffierRole(id,role);
    }
    @Operation(summary = "SupprimerRole",description = "Supprimer les roles")
    public String suppRole(Long id){
        roleService.suppRole(id);
        return "role supprimer";
    }

}
