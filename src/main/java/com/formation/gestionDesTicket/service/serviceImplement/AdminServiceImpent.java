package com.formation.gestionDesTicket.service.serviceImplement;

import com.formation.gestionDesTicket.model.Admin;
import com.formation.gestionDesTicket.repository.AdminRepository;
import com.formation.gestionDesTicket.service.AdminService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Data
public class AdminServiceImpent implements AdminService {
    private final AdminRepository adminRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public Admin creer(Admin admin) {
        admin.setMdp(passwordEncoder.encode(admin.getMdp()));
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> lire() {
        return adminRepository.findAll();
    }

    @Override
    public Admin modifier(Long idAdmin, Admin admin) {
        return adminRepository.findById(idAdmin)
                .map(a->{
                    a.setNom(admin.getNom());
                    a.setPrenom(admin.getPrenom());
                    a.setEmail(admin.getEmail());
                    a.setMdp(a.getMdp());
                    return adminRepository.save(a);
                }).orElseThrow(()-> new RuntimeException("Admin non trouver"));
    }

    @Override
    public String supprimer(Long idAdmin) {
        adminRepository.deleteById(idAdmin);
        return "Admin supprimer";
    }
}
