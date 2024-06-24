package com.formation.gestionDesTicket.repository;

import com.formation.gestionDesTicket.model.Admin;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository <Admin, Long>{

}
