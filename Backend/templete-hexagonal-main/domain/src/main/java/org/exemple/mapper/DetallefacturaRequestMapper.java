package org.exemple.mapper;


import org.exemple.data.DetallefacturaDTO;
import org.exemple.data.request.DetallefacturaDTORequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DetallefacturaRequestMapper {
    DetallefacturaRequestMapper INSTANCE = Mappers.getMapper(DetallefacturaRequestMapper.class);
    DetallefacturaDTO detallefacturaDTOToDetallefactura(DetallefacturaDTORequest detallefactura);
    DetallefacturaDTO detallefacturaToDetallefacturaDTO(DetallefacturaDTO detallefacturaDTO);
}
