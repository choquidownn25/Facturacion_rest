package org.example.configuration;

import org.example.adapters.ClienteJpaAdapter;
import org.exemple.ports.api.ClienteServicePort;
import org.exemple.ports.spi.ClientePersistencePort;
import org.exemple.service.ClienteServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteConfig {
    @Bean
    public ClientePersistencePort clientePersistencePort(){
        return  new ClienteJpaAdapter();
    }
    @Bean
    public ClienteServicePort clienteServicePort(){ return new ClienteServiceImpl(clientePersistencePort());
    }

}
