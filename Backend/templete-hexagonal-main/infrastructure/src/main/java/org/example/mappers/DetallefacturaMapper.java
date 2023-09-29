package org.example.mappers;

import org.example.entity.Detallefactura;
import org.exemple.data.DetallefacturaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DetallefacturaMapper {
    DetallefacturaMapper INSTANCE = Mappers.getMapper(DetallefacturaMapper.class);
    DetallefacturaDTO detallefacturaDTOToDetallefactura(Detallefactura detallefactura);
    Detallefactura detallefacturaToDetallefacturaDTO(DetallefacturaDTO detallefacturaDTO);
    List<DetallefacturaDTO> detallefacturaDTOListoDetallefacturaList(List<Detallefactura> detallefacturaList);
    List<Detallefactura> detallefacturaListoDetallefacturaDTOList(List<DetallefacturaDTO> detallefacturaDTOList);
}
