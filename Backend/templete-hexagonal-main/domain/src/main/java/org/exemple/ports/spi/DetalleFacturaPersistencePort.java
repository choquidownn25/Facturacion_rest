package org.exemple.ports.spi;

import org.exemple.data.DetallefacturaDTO;
import java.util.List;

public interface DetalleFacturaPersistencePort {
    DetallefacturaDTO addDetalleFactura(DetallefacturaDTO detallefacturaDTO);
    DetallefacturaDTO updateDetalleFactura(DetallefacturaDTO detallefacturaDTO);
    void removeDetalleFactura(Integer id);
    List<DetallefacturaDTO> getDetalleFacturasList();
    DetallefacturaDTO getDetalleFacturasByDetalleFactura(Integer id);
    public Double calcularTotalPorCodigoFactura(Integer codigoFactura);
}
