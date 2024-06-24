package com.formation.gestionDesTicket.securiteConfig;

import com.formation.gestionDesTicket.model.Utilisateur;
import com.formation.gestionDesTicket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Optional<Utilisateur> user= userRepository.findByEmail(email);
       if(user.isPresent()){
           var userObjet=user.get();
          return  User.builder()
                  .username(userObjet.getEmail())
                  .password(userObjet.getMdp())
                  .roles(getRole(userObjet))
                  .build();
       }else {
           throw new UsernameNotFoundException(email);
       }
    }

    private String[] getRole(Utilisateur user) {
        if(user.getRole()==null){
            return new  String[]{"ADMIN","APPRENANT","FORMATEUR"} ;
        }
        return user.getRole().split(",");
    }
}
