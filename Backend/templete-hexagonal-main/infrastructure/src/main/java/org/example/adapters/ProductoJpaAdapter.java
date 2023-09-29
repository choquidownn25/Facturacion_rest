package org.example.adapters;

import org.example.entity.Producto;
import org.example.mappers.ProductoMapper;
import org.example.repository.ProductoRepository;
import org.exemple.data.ProductoDTO;
import org.exemple.ports.spi.ProductoPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoJpaAdapter implements ProductoPersistencePort {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public ProductoDTO addProducto(ProductoDTO productoDTO) {
        Producto producto = ProductoMapper.INSTANCE.productoToProductoDTO(productoDTO);
        Producto response = productoRepository.save(producto);
        ProductoDTO productosDTO = ProductoMapper.INSTANCE.productoDTOToProducto(response);
        return productosDTO;
    }

    @Override
    public ProductoDTO updateProducto(ProductoDTO productoDTO) {
        Producto producto = ProductoMapper.INSTANCE.productoToProductoDTO(productoDTO);
        Producto response = productoRepository.save(producto);
        ProductoDTO productosDTO = ProductoMapper.INSTANCE.productoDTOToProducto(response);
        return productosDTO;
    }

    @Override
    public void removeProducto(Integer id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<ProductoDTO> getProductosList() {
        List<Producto>productoList=productoRepository.findAll();
        return ProductoMapper.INSTANCE.productoListDTOToProductlIST(productoList);

    }

    @Override
    public ProductoDTO getProductosByProducto(Integer id) {
        //Encuentra el registro
        Optional<Producto> productoId=productoRepository.findById(id);
        if (productoId.isPresent()) {
            return ProductoMapper.INSTANCE.productoDTOToProducto(productoId.get());
        }
        return null;
    }
}
