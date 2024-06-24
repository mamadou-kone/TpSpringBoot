package com.formation.gestionDesTicket.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Apprenant extends Utilisateur {

    @OneToMany(mappedBy = "apprenant")
    private Set<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;
}
