package org.exemple.service;


import org.exemple.data.DetallefacturaDTO;
import org.exemple.data.ProductoDTO;
import org.exemple.data.request.DetallefacturaDTORequest;
import org.exemple.data.request.ProductoDTORequest;
import org.exemple.data.response.DetallefacturaDTOResponse;
import org.exemple.data.response.Message;
import org.exemple.data.response.ProductoDTOResponse;
import org.exemple.mapper.DetallefacturaRequestMapper;
import org.exemple.mapper.ProductoRequestMapper;
import org.exemple.ports.api.DetalleFacturaServicePort;
import org.exemple.ports.api.ProductoServicePort;
import org.exemple.ports.spi.DetalleFacturaPersistencePort;
import org.exemple.ports.spi.ProductoPersistencePort;
import org.exemple.utils.StringResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class DetallefacturaServiceImpl implements DetalleFacturaServicePort {
    private final DetalleFacturaPersistencePort detallefacturaPersistencePort;
    @Autowired
    public DetallefacturaServiceImpl(DetalleFacturaPersistencePort detallefacturaPersistencePort) {
        this.detallefacturaPersistencePort = detallefacturaPersistencePort;
    }


    @Override
    public DetallefacturaDTOResponse addDetalleFactura(DetallefacturaDTORequest detallefacturaDTORequest) {
        DetallefacturaDTOResponse response=new DetallefacturaDTOResponse();
        DetallefacturaDTO detallefacturaDTO = new DetallefacturaDTO();
        Message message=new Message();
        List<DetallefacturaDTO> detallefacturaDTOList = new ArrayList<>();
        if(detallefacturaDTORequest == null ){
            message.setEcho (StringResponse.ErrorSAVETICKET.getName());
            message.setCode( StringResponse.ErrorSAVETICKET.getCode());
            response.setMessage( message);

        } else {
            //Se agrega dato
            DetallefacturaDTO detallefacturaDTOs = DetallefacturaRequestMapper.INSTANCE.detallefacturaDTOToDetallefactura(detallefacturaDTORequest);;

            if (detallefacturaDTOs.getCantidad()<=0 ){
                message.setEcho (StringResponse.ErrorSAVETICKET.getName());
                message.setCode( StringResponse.ErrorSAVETICKET.getCode());
                response.setMessage( message);
            }
            DetallefacturaDTO detallefacturaInsert = detallefacturaPersistencePort.addDetalleFactura(detallefacturaDTOs);
            if(detallefacturaInsert == null){
                message.setEcho (StringResponse.ErrorSAVETICKET.getName());
                message.setCode( StringResponse.ErrorSAVETICKET.getCode());
                response.setMessage( message);
            }else{
                detallefacturaDTOList.add(detallefacturaInsert);
                message.setEcho (StringResponse.OK.getName());
                message.setCode( StringResponse.OK.getCode());
                response.setMessage( message);
                response.setListDetallefacturaDTO(detallefacturaDTOList);
            }
        }
        return response;
    }

    @Override
    public DetallefacturaDTOResponse updateDetalleFactura(DetallefacturaDTORequest detallefacturaDTORequest) {
        DetallefacturaDTOResponse response=new DetallefacturaDTOResponse();
        DetallefacturaDTO detallefacturaDTO = new DetallefacturaDTO();
        Message message=new Message();
        List<DetallefacturaDTO> detallefacturaDTOList = new ArrayList<>();
        if(detallefacturaDTORequest == null ){
            message.setEcho (StringResponse.ErrorSAVETICKET.getName());
            message.setCode( StringResponse.ErrorSAVETICKET.getCode());
            response.setMessage( message);

        } else {
            DetallefacturaDTO detallefacturaDTOs = DetallefacturaRequestMapper.INSTANCE.detallefacturaDTOToDetallefactura(detallefacturaDTORequest);

            if (detallefacturaDTOs.getCantidad()<=0 ){
                message.setEcho (StringResponse.ErrorSAVETICKET.getName());
                message.setCode( StringResponse.ErrorSAVETICKET.getCode());
                response.setMessage( message);
            }
            DetallefacturaDTO detallefacturaInsert = detallefacturaPersistencePort.updateDetalleFactura(detallefacturaDTOs);
            if(detallefacturaInsert == null){
                message.setEcho (StringResponse.ErrorSAVETICKET.getName());
                message.setCode( StringResponse.ErrorSAVETICKET.getCode());
                response.setMessage( message);
            }else{
                detallefacturaDTOList.add(detallefacturaInsert);
                message.setEcho (StringResponse.OK.getName());
                message.setCode( StringResponse.OK.getCode());
                response.setMessage( message);
                response.setListDetallefacturaDTO(detallefacturaDTOList);
            }
        }
        return response;
    }

    @Override
    public void removeDetalleFactura(Integer id) {
        try {
            detallefacturaPersistencePort.removeDetalleFactura(id);
        }catch (Exception e){
            throw new RuntimeException( "Error " + e.getMessage());
        }
    }

    @Override
    public List<DetallefacturaDTO> getDetalleFacturasList() {
        return detallefacturaPersistencePort.getDetalleFacturasList();
    }

    @Override
    public DetallefacturaDTOResponse getDetalleFacturaDTOById(Integer id) {
        DetallefacturaDTOResponse response=new DetallefacturaDTOResponse();
        DetallefacturaDTO detallefacturaDTO = new DetallefacturaDTO();
        Message message=new Message();
        List<DetallefacturaDTO> detallefacturaDTOList = new ArrayList<>();
        detallefacturaDTO = detallefacturaPersistencePort.getDetalleFacturasByDetalleFactura(id);
        if(detallefacturaDTO==null){
            message.setEcho (StringResponse.ErrorNOHAYTICKET.getName());
            message.setCode( StringResponse.ErrorNOHAYTICKET.getCode());
            response.setMessage( message);
        }else {
            detallefacturaDTOList.add(detallefacturaDTO);
            message.setEcho (StringResponse.MOSTRARTICKET.getName());
            message.setCode( StringResponse.MOSTRARTICKET.getCode());
            response.setMessage( message);
            response.setListDetallefacturaDTO(detallefacturaDTOList);
        }
        return response;
    }

    @Override
    public Double calcularTotalPorCodigoFactura(Integer codigoFactura) {
        return detallefacturaPersistencePort.calcularTotalPorCodigoFactura(codigoFactura);
    }
}
