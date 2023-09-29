package org.exemple.ports.api;

import org.exemple.data.ClienteDTO;
import org.exemple.data.request.ClienteDTORequest;

import org.exemple.data.response.ClienteDTOResponse;

import java.util.List;

public interface ClienteServicePort {
    ClienteDTOResponse addCliente(ClienteDTORequest clienteDTORequest);
    ClienteDTOResponse updateCliente(ClienteDTORequest clienteDTORequest);
    void removeCliente(Integer id);
    List<ClienteDTO> getClientesList();
    ClienteDTOResponse getClienteDTOById(Integer id);

}
