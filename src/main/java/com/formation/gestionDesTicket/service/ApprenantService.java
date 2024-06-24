package com.formation.gestionDesTicket.service;

import com.formation.gestionDesTicket.model.Apprenant;

import java.util.List;

public interface ApprenantService {
    Apprenant creer(Apprenant apprenant);
    List<Apprenant>lire();
    Apprenant modifApprenant(Long idApprenant, Apprenant apprenant);
    String supprApprenant(Long idApprenant);
}
