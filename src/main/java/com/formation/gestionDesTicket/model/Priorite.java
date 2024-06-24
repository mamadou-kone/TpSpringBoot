package com.formation.gestionDesTicket.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table (name = "priorite")
@Data
public class Priorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPriorite;
    private String nomPriorite;
    @OneToMany(mappedBy = "priorite")
    private List<Ticket>tickets;
}
