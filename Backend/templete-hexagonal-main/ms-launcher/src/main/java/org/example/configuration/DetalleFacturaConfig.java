package org.example.configuration;

import org.example.adapters.DetallefacturaJpaAdapter;
import org.example.adapters.ProductoJpaAdapter;
import org.exemple.ports.api.DetalleFacturaServicePort;
import org.exemple.ports.api.ProductoServicePort;
import org.exemple.ports.spi.DetalleFacturaPersistencePort;
import org.exemple.service.DetallefacturaServiceImpl;
import org.exemple.service.ProductoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DetalleFacturaConfig {
    @Bean
    public DetalleFacturaPersistencePort detallefacturaPersistencePort(){
        return  new DetallefacturaJpaAdapter();
    }
    @Bean
    public DetalleFacturaServicePort detallefacturaServicePort(){ return new DetallefacturaServiceImpl(detallefacturaPersistencePort());
    }
 
}
