package com.formation.gestionDesTicket.service.serviceImplement;

import com.formation.gestionDesTicket.model.Role;
import com.formation.gestionDesTicket.repository.RoleRepository;
import com.formation.gestionDesTicket.service.RoleService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Data
public class RoleServiceImplement implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role creerRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> lire() {
        return roleRepository.findAll();
    }

    @Override
    public Role modiffierRole(Long id, Role role) {
        return roleRepository.findById(id).map((r)->{
            r.setNom(r.getNom());
            return roleRepository.save(role);
        }).orElseThrow(()->new RuntimeException("Role introuvable"));
    }

    @Override
    public String suppRole(Long id) {
        roleRepository.deleteById(id);
        return "Role Supprimer";
    }
}
