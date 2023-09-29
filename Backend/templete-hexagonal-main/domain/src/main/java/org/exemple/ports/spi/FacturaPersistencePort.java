package org.exemple.ports.spi;

import org.exemple.data.FacturaDTO;
import org.exemple.data.FacturaTotalDTO;
import org.exemple.data.FacturaTotalSubTotalDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FacturaPersistencePort {
    FacturaDTO addDetalleFactura(FacturaDTO facturaDTO);
    FacturaDTO updateDetalleFactura(FacturaDTO facturaDTO);
    void removeDetalleFactura(Integer id);
    List<FacturaDTO> getDetalleFacturasList();
    FacturaDTO getDetalleFacturasByDetalleFactura(Integer id);
    List<FacturaTotalDTO>  calcularTotalesPorFactura(Integer facturaId);
    List<Object[]> calcularSubtotalYTotalPorFactura( Integer facturaId);
    List<FacturaTotalSubTotalDTO> subotalTotalesPorFactura(Integer facturaId);
}
