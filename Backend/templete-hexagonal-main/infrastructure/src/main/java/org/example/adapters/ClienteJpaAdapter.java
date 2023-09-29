package org.example.adapters;

import org.example.entity.Cliente;
import org.example.mappers.ClienteMapper;
import org.example.repository.ClienteRepository;
import org.exemple.data.ClienteDTO;
import org.exemple.ports.spi.ClientePersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteJpaAdapter implements ClientePersistencePort {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClienteDTO addCliente(ClienteDTO clienteDTO) {
        Cliente cliente = ClienteMapper.INSTANCE.clienteToClienteDTO(clienteDTO);
        Cliente response = clienteRepository.save(cliente);
        ClienteDTO clientesDTO = ClienteMapper.INSTANCE.clienteDTOToCliente(response);
        return clientesDTO;
    }

    @Override
    public ClienteDTO updateCliente(ClienteDTO clienteDTO) {
        Cliente cliente = ClienteMapper.INSTANCE.clienteToClienteDTO(clienteDTO);
        Cliente response = clienteRepository.save(cliente);
        ClienteDTO clientesDTO = ClienteMapper.INSTANCE.clienteDTOToCliente(response);
        return clientesDTO;
    }

    @Override
    public void removeCliente(Integer id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<ClienteDTO> getClientesList() {
        List<Cliente>clienteList=clienteRepository.findAll();
        return ClienteMapper.INSTANCE.clienteListDTOToCliente(clienteList);

    }

    @Override
    public ClienteDTO getClientesByCliente(Integer id) {
        //Encuentra el registro
        Optional<Cliente> clienteId=clienteRepository.findById(id);
        if (clienteId.isPresent()) {
            return ClienteMapper.INSTANCE.clienteDTOToCliente(clienteId.get());
        }
        return null;
    }
}
