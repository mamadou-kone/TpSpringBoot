package com.formation.gestionDesTicket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Admin extends Utilisateur {
    @JsonIgnore
    @OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
    private Set<Formateur> formateurs;
}
