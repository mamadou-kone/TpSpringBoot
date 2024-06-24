package com.formation.gestionDesTicket.service;

import com.formation.gestionDesTicket.model.Role;

import java.util.List;

public interface RoleService {
    Role creerRole(Role role);
    List<Role> lire();
    Role modiffierRole(Long id,Role role);
    String suppRole(Long id);

}
