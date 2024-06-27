package com.formation.gestionDesTicket.securiteConfig;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;



public class Swagger {

    @Bean
    public OpenAPI custOpenAPI(){
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("AssitantTicket")
                        .description("Api de gestion de ticket au sein de kalanso")
                                .version("0.0.1")
                                .termsOfService("http:swagger.io/terms/")
                        .contact(new Contact().name("Mamadou").email("momedkone2@gamil.com") )
                        );

    }
}
