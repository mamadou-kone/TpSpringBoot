package com.formation.gestionDesTicket.service;

import com.formation.gestionDesTicket.model.Admin;

import java.util.List;

public interface AdminService {
    Admin creer(Admin admin);
    List<Admin> lire();

    Admin modifier(Long idAdmin, Admin admin);

    String supprimer(Long idAdmin);

}
