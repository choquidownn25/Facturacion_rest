package org.exemple.service;


import org.exemple.data.DetallefacturaDTO;
import org.exemple.data.FacturaDTO;
import org.exemple.data.FacturaTotalDTO;
import org.exemple.data.FacturaTotalSubTotalDTO;
import org.exemple.data.request.DetallefacturaDTORequest;
import org.exemple.data.request.FacturaDTORequest;
import org.exemple.data.response.DetallefacturaDTOResponse;
import org.exemple.data.response.FacturaDTOResponse;
import org.exemple.data.response.Message;
import org.exemple.mapper.DetallefacturaRequestMapper;
import org.exemple.mapper.FacturaRequestMapper;
import org.exemple.ports.api.DetalleFacturaServicePort;
import org.exemple.ports.api.FacturaServicePort;
import org.exemple.ports.spi.DetalleFacturaPersistencePort;
import org.exemple.ports.spi.FacturaPersistencePort;
import org.exemple.utils.StringResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FacturaServiceImpl implements FacturaServicePort {
    private final FacturaPersistencePort facturaPersistencePort;
    @Autowired
    public FacturaServiceImpl(FacturaPersistencePort facturaPersistencePort) {
        this.facturaPersistencePort = facturaPersistencePort;
    }


    @Override
    public FacturaDTOResponse addFactura(FacturaDTORequest facturaDTORequest) {
        FacturaDTOResponse response=new FacturaDTOResponse();
        FacturaDTO facturaDTO = new FacturaDTO();
        Message message=new Message();
        List<FacturaDTO> facturaDTOList = new ArrayList<>();
        if(facturaDTORequest == null ){
            message.setEcho (StringResponse.ErrorSAVETICKET.getName());
            message.setCode( StringResponse.ErrorSAVETICKET.getCode());
            response.setMessage( message);

        } else {
            //Se agrega dato
            FacturaDTO facturaDTOs = FacturaRequestMapper.INSTANCE.facturaDTOToFactura(facturaDTORequest);;

            if (facturaDTOs.getCliente().getId()>0 ){
                message.setEcho (StringResponse.ErrorSAVETICKET.getName());
                message.setCode( StringResponse.ErrorSAVETICKET.getCode());
                response.setMessage( message);
            }

            facturaDTOs.setFechacreate(new Date());
            FacturaDTO facturaInsert = facturaPersistencePort.addDetalleFactura(facturaDTOs);
            if(facturaInsert == null){
                message.setEcho (StringResponse.ErrorSAVETICKET.getName());
                message.setCode( StringResponse.ErrorSAVETICKET.getCode());
                response.setMessage( message);
            }else{
                facturaDTOList.add(facturaInsert);
                message.setEcho (StringResponse.OK.getName());
                message.setCode( StringResponse.OK.getCode());
                response.setMessage( message);
                response.setListFacturaDTO(facturaDTOList);
            }
        }
        return response;
    }

    @Override
    public FacturaDTOResponse updateFactura(FacturaDTORequest facturaDTORequest) {
        FacturaDTOResponse response=new FacturaDTOResponse();
        FacturaDTO facturaDTO = new FacturaDTO();
        Message message=new Message();
        List<FacturaDTO> facturaDTOList = new ArrayList<>();
        if(facturaDTORequest == null ){
            message.setEcho (StringResponse.ErrorSAVETICKET.getName());
            message.setCode( StringResponse.ErrorSAVETICKET.getCode());
            response.setMessage( message);

        } else {
            FacturaDTO facturaDTOs = FacturaRequestMapper.INSTANCE.facturaDTOToFactura(facturaDTORequest);

            if (facturaDTOs.getCliente().getId()>0 ){
                message.setEcho (StringResponse.ErrorSAVETICKET.getName());
                message.setCode( StringResponse.ErrorSAVETICKET.getCode());
                response.setMessage( message);
            }

            facturaDTOs.setFechacreate(new Date());
            FacturaDTO facturaInsert = facturaPersistencePort.updateDetalleFactura(facturaDTOs);
            if(facturaInsert == null){
                message.setEcho (StringResponse.ErrorSAVETICKET.getName());
                message.setCode( StringResponse.ErrorSAVETICKET.getCode());
                response.setMessage( message);
            }else{
                facturaDTOList.add(facturaInsert);
                message.setEcho (StringResponse.OK.getName());
                message.setCode( StringResponse.OK.getCode());
                response.setMessage( message);
                response.setListFacturaDTO(facturaDTOList);
            }
        }
        return response;
    }

    @Override
    public void removeFactura(Integer id) {
        try {
            facturaPersistencePort.removeDetalleFactura(id);
        }catch (Exception e){
            throw new RuntimeException( "Error " + e.getMessage());
        }
    }

    @Override
    public List<FacturaDTO> getFacturasList() {
        return facturaPersistencePort.getDetalleFacturasList();
    }

    @Override
    public FacturaDTOResponse getFacturaDTOById(Integer id) {
        FacturaDTOResponse response=new FacturaDTOResponse();
        FacturaDTO facturaDTO = new FacturaDTO();
        Message message=new Message();
        List<FacturaDTO> facturaDTOList = new ArrayList<>();
        facturaDTO = facturaPersistencePort.getDetalleFacturasByDetalleFactura(id);
        if(facturaDTO==null){
            message.setEcho (StringResponse.ErrorNOHAYTICKET.getName());
            message.setCode( StringResponse.ErrorNOHAYTICKET.getCode());
            response.setMessage( message);
        }else {
            facturaDTOList.add(facturaDTO);
            message.setEcho (StringResponse.MOSTRARTICKET.getName());
            message.setCode( StringResponse.MOSTRARTICKET.getCode());
            response.setMessage( message);
            response.setListFacturaDTO(facturaDTOList);
        }
        return response;
    }

    @Override
    public List<FacturaTotalDTO> calcularTotalesPorFactura(Integer facturaId) {
        return facturaPersistencePort.calcularTotalesPorFactura(facturaId);
    }

    @Override
    public List<Object[]> calcularSubtotalYTotalPorFactura(Integer facturaId) {
        return facturaPersistencePort.calcularSubtotalYTotalPorFactura(facturaId);
    }

    @Override
    public List<FacturaTotalSubTotalDTO> subotalTotalesPorFactura(Integer facturaId) {
        return facturaPersistencePort.subotalTotalesPorFactura(facturaId);
    }
}
