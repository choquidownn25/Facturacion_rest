package org.exemple.mapper;


import org.exemple.data.FacturaDTO;
import org.exemple.data.request.FacturaDTORequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FacturaRequestMapper {
    FacturaRequestMapper INSTANCE = Mappers.getMapper(FacturaRequestMapper.class);
    FacturaDTO facturaDTOToFactura(FacturaDTORequest factura);
    FacturaDTO facturaToFacturaDTO(FacturaDTO facturaDTO);

}
