package org.exemple.service;


import org.exemple.data.ClienteDTO;
import org.exemple.data.request.ClienteDTORequest;
import org.exemple.data.response.ClienteDTOResponse;
import org.exemple.data.response.Message;
import org.exemple.mapper.ClienteRequestMapper;
import org.exemple.ports.api.ClienteServicePort;
import org.exemple.ports.spi.ClientePersistencePort;
import org.exemple.utils.StringResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClienteServiceImpl implements ClienteServicePort {
    private final ClientePersistencePort clientePersistencePort;
    @Autowired
    public ClienteServiceImpl(ClientePersistencePort clientePersistencePort) {
        this.clientePersistencePort = clientePersistencePort;
    }


    @Override
    public ClienteDTOResponse addCliente(ClienteDTORequest clienteDTORequest) {
        ClienteDTOResponse response=new ClienteDTOResponse();
        ClienteDTO clienteDTO = new ClienteDTO();
        Message message=new Message();
        List<ClienteDTO> clienteDTOList = new ArrayList<>();
        if(clienteDTORequest == null ){
            message.setEcho (StringResponse.ErrorSAVETICKET.getName());
            message.setCode( StringResponse.ErrorSAVETICKET.getCode());
            response.setMessage( message);

        } else {
            //Se agrega dato
            ClienteDTO clienteDTOs = ClienteRequestMapper.INSTANCE.clienteDTOToCliente(clienteDTORequest);;

            if (clienteDTOs.getNombre().length()>10 ){
                message.setEcho (StringResponse.ErrorSAVETICKET.getName());
                message.setCode( StringResponse.ErrorSAVETICKET.getCode());
                response.setMessage( message);
            }
            ClienteDTO clienteInsert = clientePersistencePort.addCliente(clienteDTOs);
            if(clienteInsert == null){
                message.setEcho (StringResponse.ErrorSAVETICKET.getName());
                message.setCode( StringResponse.ErrorSAVETICKET.getCode());
                response.setMessage( message);
            }else{
                clienteDTOList.add(clienteInsert);
                message.setEcho (StringResponse.OK.getName());
                message.setCode( StringResponse.OK.getCode());
                response.setMessage( message);
                response.setListClienteDTO(clienteDTOList);
            }
        }
        return response;
    }

    @Override
    public ClienteDTOResponse updateCliente(ClienteDTORequest clienteDTORequest) {
        ClienteDTOResponse response=new ClienteDTOResponse();
        ClienteDTO clienteDTO = new ClienteDTO();
        Message message=new Message();
        List<ClienteDTO> clienteDTOList = new ArrayList<>();
        if(clienteDTORequest == null ){
            message.setEcho (StringResponse.ErrorSAVETICKET.getName());
            message.setCode( StringResponse.ErrorSAVETICKET.getCode());
            response.setMessage( message);

        } else {
            ClienteDTO clienteDTOs = ClienteRequestMapper.INSTANCE.clienteDTOToCliente(clienteDTORequest);

            if (clienteDTOs.getNombre().length() > 10){
                message.setEcho (StringResponse.ErrorSAVETICKET.getName());
                message.setCode( StringResponse.ErrorSAVETICKET.getCode());
                response.setMessage( message);
            }
            ClienteDTO clienteInsert = clientePersistencePort.updateCliente(clienteDTOs);
            if(clienteInsert == null){
                message.setEcho (StringResponse.ErrorSAVETICKET.getName());
                message.setCode( StringResponse.ErrorSAVETICKET.getCode());
                response.setMessage( message);
            }else{
                clienteDTOList.add(clienteInsert);
                message.setEcho (StringResponse.OK.getName());
                message.setCode( StringResponse.OK.getCode());
                response.setMessage( message);
                response.setListClienteDTO(clienteDTOList);
            }
        }
        return response;
    }

    @Override
    public void removeCliente(Integer id) {
        try {
            clientePersistencePort.removeCliente(id);
        }catch (Exception e){
            throw new RuntimeException( "Error " + e.getMessage());
        }
    }

    @Override
    public List<ClienteDTO> getClientesList() {
        return clientePersistencePort.getClientesList();
    }

    @Override
    public ClienteDTOResponse getClienteDTOById(Integer id) {
        ClienteDTOResponse response=new ClienteDTOResponse();
        ClienteDTO clienteDTO = new ClienteDTO();
        Message message=new Message();
        List<ClienteDTO> clienteDTOList = new ArrayList<>();
        clienteDTO = clientePersistencePort.getClientesByCliente(id);
        if(clienteDTO==null){
            message.setEcho (StringResponse.ErrorNOHAYTICKET.getName());
            message.setCode( StringResponse.ErrorNOHAYTICKET.getCode());
            response.setMessage( message);
        }else {
            clienteDTOList.add(clienteDTO);
            message.setEcho (StringResponse.MOSTRARTICKET.getName());
            message.setCode( StringResponse.MOSTRARTICKET.getCode());
            response.setMessage( message);
            response.setListClienteDTO(clienteDTOList);
        }
        return response;
    }
}
