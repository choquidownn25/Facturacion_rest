package org.exemple.service;


import org.exemple.data.ClienteDTO;
import org.exemple.data.ProductoDTO;
import org.exemple.data.request.ClienteDTORequest;
import org.exemple.data.request.ProductoDTORequest;
import org.exemple.data.response.ClienteDTOResponse;
import org.exemple.data.response.Message;
import org.exemple.data.response.ProductoDTOResponse;
import org.exemple.mapper.ClienteRequestMapper;
import org.exemple.mapper.ProductoRequestMapper;
import org.exemple.ports.api.ClienteServicePort;
import org.exemple.ports.api.ProductoServicePort;
import org.exemple.ports.spi.ClientePersistencePort;
import org.exemple.ports.spi.ProductoPersistencePort;
import org.exemple.utils.StringResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProductoServiceImpl implements ProductoServicePort {
    private final ProductoPersistencePort productoPersistencePort;
    @Autowired
    public ProductoServiceImpl(ProductoPersistencePort productoPersistencePort) {
        this.productoPersistencePort = productoPersistencePort;
    }


    @Override
    public ProductoDTOResponse addProducto(ProductoDTORequest productoDTORequest) {
        ProductoDTOResponse response=new ProductoDTOResponse();
        ProductoDTO productoDTO = new ProductoDTO();
        Message message=new Message();
        List<ProductoDTO> productoDTOList = new ArrayList<>();
        if(productoDTORequest == null ){
            message.setEcho (StringResponse.ErrorSAVETICKET.getName());
            message.setCode( StringResponse.ErrorSAVETICKET.getCode());
            response.setMessage( message);

        } else {
            //Se agrega dato
            ProductoDTO productoDTOs = ProductoRequestMapper.INSTANCE.productoDTOToProducto(productoDTORequest);;

            if (productoDTOs.getNombre().length()>10 ){
                message.setEcho (StringResponse.ErrorSAVETICKET.getName());
                message.setCode( StringResponse.ErrorSAVETICKET.getCode());
                response.setMessage( message);
            }
            ProductoDTO productoInsert = productoPersistencePort.addProducto(productoDTOs);
            if(productoInsert == null){
                message.setEcho (StringResponse.ErrorSAVETICKET.getName());
                message.setCode( StringResponse.ErrorSAVETICKET.getCode());
                response.setMessage( message);
            }else{
                productoDTOList.add(productoInsert);
                message.setEcho (StringResponse.OK.getName());
                message.setCode( StringResponse.OK.getCode());
                response.setMessage( message);
                response.setListProductoDTO(productoDTOList);
            }
        }
        return response;
    }

    @Override
    public ProductoDTOResponse updateProducto(ProductoDTORequest productoDTORequest) {
        ProductoDTOResponse response=new ProductoDTOResponse();
        ProductoDTO productoDTO = new ProductoDTO();
        Message message=new Message();
        List<ProductoDTO> productoDTOList = new ArrayList<>();
        if(productoDTORequest == null ){
            message.setEcho (StringResponse.ErrorSAVETICKET.getName());
            message.setCode( StringResponse.ErrorSAVETICKET.getCode());
            response.setMessage( message);

        } else {
            ProductoDTO productoDTOs = ProductoRequestMapper.INSTANCE.productoDTOToProducto(productoDTORequest);

            if (productoDTOs.getNombre().length() > 10){
                message.setEcho (StringResponse.ErrorSAVETICKET.getName());
                message.setCode( StringResponse.ErrorSAVETICKET.getCode());
                response.setMessage( message);
            }
            ProductoDTO productoInsert = productoPersistencePort.updateProducto(productoDTOs);
            if(productoInsert == null){
                message.setEcho (StringResponse.ErrorSAVETICKET.getName());
                message.setCode( StringResponse.ErrorSAVETICKET.getCode());
                response.setMessage( message);
            }else{
                productoDTOList.add(productoInsert);
                message.setEcho (StringResponse.OK.getName());
                message.setCode( StringResponse.OK.getCode());
                response.setMessage( message);
                response.setListProductoDTO(productoDTOList);
            }
        }
        return response;
    }

    @Override
    public void removeProducto(Integer id) {
        try {
            productoPersistencePort.removeProducto(id);
        }catch (Exception e){
            throw new RuntimeException( "Error " + e.getMessage());
        }
    }

    @Override
    public List<ProductoDTO> getProductosList() {
        return productoPersistencePort.getProductosList();
    }

    @Override
    public ProductoDTOResponse getProductoDTOById(Integer id) {
        ProductoDTOResponse response=new ProductoDTOResponse();
        ProductoDTO productoDTO = new ProductoDTO();
        Message message=new Message();
        List<ProductoDTO> productoDTOList = new ArrayList<>();
        productoDTO = productoPersistencePort.getProductosByProducto(id);
        if(productoDTO==null){
            message.setEcho (StringResponse.ErrorNOHAYTICKET.getName());
            message.setCode( StringResponse.ErrorNOHAYTICKET.getCode());
            response.setMessage( message);
        }else {
            productoDTOList.add(productoDTO);
            message.setEcho (StringResponse.MOSTRARTICKET.getName());
            message.setCode( StringResponse.MOSTRARTICKET.getCode());
            response.setMessage( message);
            response.setListProductoDTO(productoDTOList);
        }
        return response;
    }
}
