package org.example.configuration;

import org.example.adapters.ProductoJpaAdapter;
import org.exemple.ports.api.ProductoServicePort;
import org.exemple.ports.spi.ProductoPersistencePort;
import org.exemple.service.ProductoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductoConfig {
    @Bean
    public ProductoPersistencePort productoPersistencePort(){
        return  new ProductoJpaAdapter();
    }
    @Bean
    public ProductoServicePort productoServicePort(){ return new ProductoServiceImpl(productoPersistencePort());
    }
 
}
