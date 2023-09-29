package org.exemple.ports.api;

import org.exemple.data.ProductoDTO;
import org.exemple.data.request.ProductoDTORequest;
import org.exemple.data.response.ProductoDTOResponse;

import java.util.List;

public interface ProductoServicePort {
    ProductoDTOResponse addProducto(ProductoDTORequest productoDTORequest);
    ProductoDTOResponse updateProducto(ProductoDTORequest productoDTORequest);
    void removeProducto(Integer id);
    List<ProductoDTO> getProductosList();
    ProductoDTOResponse getProductoDTOById(Integer id);

}
