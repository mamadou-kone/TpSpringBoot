package com.formation.gestionDesTicket.service;

import com.formation.gestionDesTicket.model.Base;

import java.util.List;

public interface BaseService {
    Base creerBase(Base base);
    List<Base> lire();
    Base modifBase(Long idBase,Base base);
    String supprimBase(Long idBase);
}
