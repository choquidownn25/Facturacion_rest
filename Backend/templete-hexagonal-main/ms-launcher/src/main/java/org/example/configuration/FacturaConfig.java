package org.example.configuration;

import org.example.adapters.FacturaJpaAdapter;
import org.exemple.ports.api.FacturaServicePort;
import org.exemple.ports.spi.FacturaPersistencePort;
import org.exemple.service.FacturaServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FacturaConfig {
    @Bean
    public FacturaPersistencePort facturaPersistencePort(){
        return  new FacturaJpaAdapter();
    }
    @Bean
    public FacturaServicePort facturaServicePort(){ return new FacturaServiceImpl(facturaPersistencePort());
    }
 
}
