package com.formation.gestionDesTicket.service;

import com.formation.gestionDesTicket.model.Formateur;

import java.util.List;

public interface FormateurService {
    Formateur creer(Formateur formateur);
    List<Formateur> lire();
    Formateur modifier(Long idFormateur,Formateur formateur);
    String supprimer(Long idFormateur);
}
