package com.formation.gestionDesTicket.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Admin extends Utilisateur {

    @OneToMany(mappedBy = "admin")
    private Set<Formateur> formateurs;
}
