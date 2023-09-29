package org.example.repository;

import org.example.entity.Factura;
import org.exemple.data.FacturaTotalDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
    @Query(value = "SELECT df.codigofactura AS facturaId, SUM(df.precio * df.cantidad) AS subtotal, " +
            "SUM(df.precio * df.cantidad) + SUM(df.precio * df.cantidad) * 0.16 AS total " +
            "FROM detallefactura df WHERE df.codigofactura = :facturaId", nativeQuery = true)
    List<Object[]> calcularTotalesPorFactura(@Param("facturaId") Integer facturaId);
    @Query(value = "SELECT f.id AS facturaId, f.fecha AS facturaFecha, " +
            "c.id AS clienteId, c.nombre AS clienteNombre, " +
            "p.id AS productoId, p.descripcion AS productoDescripcion, " +
            "df.cantidad AS cantidad, df.precio AS precio, " +
            "df.cantidad * df.precio AS subtotal, " +
            " SUM(df.precio * df.cantidad) AS subtotalTotal, "+
            "SUM(df.precio * df.cantidad) + SUM(df.precio * df.cantidad) * 0.16 AS totalTotal " +
            "FROM factura f " +
            "INNER JOIN cliente c ON f.codigocliente = c.id " +
            "INNER JOIN detallefactura df ON f.id = df.codigofactura " +
            "INNER JOIN producto p ON df.codigoproducto = p.id " +
            "WHERE f.id = :facturaId", nativeQuery = true)
    List<Object[]> calcularSubtotalYTotalPorFactura(@Param("facturaId") Integer facturaId);
}