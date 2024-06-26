package com.formation.gestionDesTicket.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

@Entity
@Table (name = "Base")
@Data
@NoArgsConstructor
public class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBase;
    private String nomBase;
    private String lien;
    @ManyToOne
    private Formateur formateur;


}
