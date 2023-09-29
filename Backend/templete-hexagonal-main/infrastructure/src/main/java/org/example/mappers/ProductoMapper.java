package org.example.mappers;

import org.example.entity.Producto;
import org.exemple.data.ProductoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductoMapper {
    ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);
    ProductoDTO productoDTOToProducto(Producto producto);
    Producto productoToProductoDTO(ProductoDTO productoDTO);
    List<Producto> productoListToProductoDTOList(List<ProductoDTO> productoDTOList);
    List<ProductoDTO>productoListDTOToProductlIST(List<Producto> productoList);
}
