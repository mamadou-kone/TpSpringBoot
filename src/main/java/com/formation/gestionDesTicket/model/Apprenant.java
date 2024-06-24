package com.formation.gestionDesTicket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Apprenant extends Utilisateur {
    @JsonIgnore
    @OneToMany(mappedBy = "apprenant",cascade = CascadeType.ALL)
    private Set<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;
}
