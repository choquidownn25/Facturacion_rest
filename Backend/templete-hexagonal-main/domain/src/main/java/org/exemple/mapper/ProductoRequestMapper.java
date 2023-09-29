package org.exemple.mapper;


import org.exemple.data.ProductoDTO;
import org.exemple.data.request.ProductoDTORequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductoRequestMapper {
    ProductoRequestMapper INSTANCE = Mappers.getMapper(ProductoRequestMapper.class);
    ProductoDTO productoDTOToProducto(ProductoDTORequest producto);
    ProductoDTO productoToProductoDTO(ProductoDTO productoDTO);
   }
