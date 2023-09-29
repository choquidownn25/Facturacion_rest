package org.exemple.ports.api;



import org.exemple.data.FacturaDTO;
import org.exemple.data.FacturaTotalDTO;
import org.exemple.data.FacturaTotalSubTotalDTO;
import org.exemple.data.request.FacturaDTORequest;
import org.exemple.data.response.FacturaDTOResponse;

import java.util.List;

public interface FacturaServicePort {
    FacturaDTOResponse addFactura(FacturaDTORequest facturaDTORequest);
    FacturaDTOResponse updateFactura(FacturaDTORequest facturaDTORequest);
    void removeFactura(Integer id);
    List<FacturaDTO> getFacturasList();
    FacturaDTOResponse getFacturaDTOById(Integer id);
    List<FacturaTotalDTO>calcularTotalesPorFactura(Integer facturaId);
    List<Object[]> calcularSubtotalYTotalPorFactura( Integer facturaId);
    List<FacturaTotalSubTotalDTO> subotalTotalesPorFactura(Integer facturaId);
}
