package com.formation.gestionDesTicket.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;
    private String motif;
    private String date;
    private String statuts;
    @ManyToOne
    private Categorie categorie;
    @ManyToOne
    private Apprenant apprenant;
    @ManyToOne
    private Priorite priorite;
}
