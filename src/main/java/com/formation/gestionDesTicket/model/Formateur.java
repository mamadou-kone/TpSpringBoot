package com.formation.gestionDesTicket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Formateur extends Utilisateur {

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
    @JsonIgnore
    @OneToMany(mappedBy = "formateur",cascade = CascadeType.ALL)
    private Set<Base> bases;
}
