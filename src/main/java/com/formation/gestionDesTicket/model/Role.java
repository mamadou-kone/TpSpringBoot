package com.formation.gestionDesTicket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "role")
public class Role{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @JsonIgnore
    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
    private Set<Utilisateur> utilisateur;
}
