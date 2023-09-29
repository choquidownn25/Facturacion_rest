package org.exemple.ports.spi;

import org.exemple.data.ProductoDTO;

import java.util.List;

public interface ProductoPersistencePort {
    ProductoDTO addProducto(ProductoDTO productoDTO);
    ProductoDTO updateProducto(ProductoDTO productoDTO);
    void removeProducto(Integer id);
    List<ProductoDTO> getProductosList();
    ProductoDTO getProductosByProducto(Integer id);
}
