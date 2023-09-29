package org.exemple.ports.spi;

import org.exemple.data.ClienteDTO;

import java.util.List;

public interface ClientePersistencePort {
    ClienteDTO addCliente(ClienteDTO clienteDTO);
    ClienteDTO updateCliente(ClienteDTO clienteDTO);
    void removeCliente(Integer id);
    List<ClienteDTO> getClientesList();
    ClienteDTO getClientesByCliente(Integer id);
}
