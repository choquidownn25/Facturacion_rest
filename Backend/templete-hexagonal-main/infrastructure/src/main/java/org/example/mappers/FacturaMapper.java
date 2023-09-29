package org.example.mappers;

import org.example.entity.Factura;
import org.exemple.data.FacturaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FacturaMapper {
    FacturaMapper INSTANCE = Mappers.getMapper(FacturaMapper.class);
    FacturaDTO facturaDTOToFactura(Factura factura);
    Factura facturaToFacturaDTO(FacturaDTO facturaDTO);
    List<FacturaDTO>facturaDTOListToFacturaList(List<Factura> facturaList);
    List<Factura>facturaLisToFacturaDTOList(List<FacturaDTO> facturaDTOList);

}
