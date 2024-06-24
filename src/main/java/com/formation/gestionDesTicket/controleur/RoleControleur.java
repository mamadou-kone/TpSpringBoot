package com.formation.gestionDesTicket.controleur;

import com.formation.gestionDesTicket.model.Role;
import com.formation.gestionDesTicket.service.RoleService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("role")
public class RoleControleur {
    @Autowired
    private RoleService roleService;

    @PostMapping("/AjoutRole")
    public Role creerRole(Role role){
        return roleService.creerRole(role);
    }

    @GetMapping("/Liste/{id}")
    public List<Role> Liste(Long id){
        return roleService.lire();
    }
    @PutMapping("/modifRole/{id}")
    public Role modifRole(@PathVariable Long id,@RequestBody Role role){
        return roleService.modiffierRole(id,role);
    }
    public String suppRole(Long id){
        roleService.suppRole(id);
        return "role supprimer";
    }

}
