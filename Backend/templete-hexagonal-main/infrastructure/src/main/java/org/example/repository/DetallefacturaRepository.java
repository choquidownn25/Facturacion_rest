package org.example.repository;

import org.example.entity.Detallefactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallefacturaRepository extends JpaRepository<Detallefactura, Integer> {
}