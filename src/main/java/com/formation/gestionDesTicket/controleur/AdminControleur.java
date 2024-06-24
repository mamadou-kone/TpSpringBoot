package com.formation.gestionDesTicket.controleur;

import com.formation.gestionDesTicket.model.Admin;
import com.formation.gestionDesTicket.service.AdminService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Data
public class AdminControleur {
    private final AdminService adminService;
    @PostMapping("/creationAdmin")
    public Admin creation(@RequestBody Admin admin){
        return adminService.creer(admin);
    }


@GetMapping("/Liste")
public List<Admin> read(){
        return adminService.lire();
}
@PutMapping("modifier/{id}")
public Admin modif(@PathVariable long id,@RequestBody Admin admin){
    return adminService.modifier(id,admin);
}
@DeleteMapping("/supprimer/{id}")
public String supprim(@PathVariable long id){
        return adminService.supprimer(id);
}

}
