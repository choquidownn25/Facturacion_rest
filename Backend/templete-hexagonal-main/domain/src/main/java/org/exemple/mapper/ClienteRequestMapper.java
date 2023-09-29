package org.exemple.mapper;


import org.exemple.data.ClienteDTO;
import org.exemple.data.request.ClienteDTORequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClienteRequestMapper {
    ClienteRequestMapper INSTANCE =  Mappers.getMapper(ClienteRequestMapper.class);
    ClienteDTO clienteDTOToCliente (ClienteDTORequest cliente);
    ClienteDTO clienteToClienteDTO (ClienteDTO cliente);
}
