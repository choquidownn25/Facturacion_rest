package org.example.controller;

import org.exemple.data.ClienteDTO;
import org.exemple.data.request.ClienteDTORequest;
import org.exemple.data.response.ClienteDTOResponse;
import org.exemple.ports.api.ClienteServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteServicePort clienteServicePort;

    public ClienteController(ClienteServicePort clienteServicePort) {
        this.clienteServicePort = clienteServicePort;
    }
    @PostMapping("/add")
    public ResponseEntity<ClienteDTOResponse> addCliente(@RequestBody ClienteDTORequest clienteDTORequest){
        ClienteDTOResponse clienteDTOResponse = new ClienteDTOResponse();
        clienteDTOResponse = clienteServicePort.addCliente(clienteDTORequest);
        if(clienteDTOResponse != null) {
            return new ResponseEntity<ClienteDTOResponse>(clienteDTOResponse, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<ClienteDTOResponse>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping ("/update")
    public ResponseEntity<ClienteDTOResponse> updateCliente(@RequestBody ClienteDTORequest clienteDTORequest){
        ClienteDTOResponse clienteDTOResponse = new ClienteDTOResponse();
        clienteDTOResponse = clienteServicePort.updateCliente(clienteDTORequest);
        if(clienteDTOResponse != null) {
            return new ResponseEntity<ClienteDTOResponse>(clienteDTOResponse, HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<ClienteDTOResponse>(clienteDTOResponse, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get")
    public ResponseEntity<List<ClienteDTO>> getCliente( ){
        List<ClienteDTO> listClienteDTOResponse = new ArrayList<>();
        listClienteDTOResponse = clienteServicePort.getClientesList();
        if(listClienteDTOResponse != null) {
            return new ResponseEntity<List<ClienteDTO>>(listClienteDTOResponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<List<ClienteDTO>>(listClienteDTOResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ClienteDTOResponse> getByIdCliente(@PathVariable Integer id){
        ClienteDTOResponse clienteDTOResponse = new ClienteDTOResponse();
        clienteDTOResponse = clienteServicePort.getClienteDTOById(id);
        if(clienteDTOResponse != null) {
            return new ResponseEntity<ClienteDTOResponse>(clienteDTOResponse, HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<ClienteDTOResponse>(clienteDTOResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCliente(@PathVariable Integer id){
        clienteServicePort.removeCliente(id);
    }
}
