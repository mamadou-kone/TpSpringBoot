package com.formation.gestionDesTicket.service;

import com.formation.gestionDesTicket.model.Utilisateur;

import java.util.List;

public interface UserService {
    Utilisateur creer(Utilisateur user);
    List<Utilisateur> lire();
    Utilisateur modif(Long id, Utilisateur user);
    String supprim(Long id);
}
