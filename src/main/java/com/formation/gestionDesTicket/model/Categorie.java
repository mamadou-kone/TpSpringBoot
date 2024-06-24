package com.formation.gestionDesTicket.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "categorie")
@Data
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorie;
    private String nomCategorie;
    @OneToMany(mappedBy = "categorie")
    private Set<Ticket>ticket;

}
