package com.formation.gestionDesTicket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @OneToMany(mappedBy = "priorite",cascade = CascadeType.ALL)
    private List<Ticket>tickets;
}
