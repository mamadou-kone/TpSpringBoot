package com.formation.gestionDesTicket.service;

import com.formation.gestionDesTicket.model.Categorie;

import java.util.List;

public interface CategorieService {
    Categorie creerCategorie(Categorie categorie);
    List<Categorie> lire();
    Categorie modifCategorie(Long idCategorie,Categorie categorie);
    String supprimCategorie(Long idCategorie);
}
