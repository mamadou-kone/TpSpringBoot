package com.formation.gestionDesTicket.repository;

import com.formation.gestionDesTicket.model.Base;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository extends JpaRepository<Base, Long> {
}
