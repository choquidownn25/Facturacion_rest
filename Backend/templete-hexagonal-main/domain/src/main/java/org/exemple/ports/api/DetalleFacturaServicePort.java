package org.exemple.ports.api;



import org.exemple.data.DetallefacturaDTO;
import org.exemple.data.request.DetallefacturaDTORequest;
import org.exemple.data.response.DetallefacturaDTOResponse;

import java.util.List;

public interface DetalleFacturaServicePort {
    DetallefacturaDTOResponse addDetalleFactura(DetallefacturaDTORequest detalleFacturaDTORequest);
    DetallefacturaDTOResponse updateDetalleFactura(DetallefacturaDTORequest detalleFacturaDTORequest);
    void removeDetalleFactura(Integer id);
    List<DetallefacturaDTO> getDetalleFacturasList();
    DetallefacturaDTOResponse getDetalleFacturaDTOById(Integer id);
    public Double calcularTotalPorCodigoFactura(Integer codigoFactura);

}
