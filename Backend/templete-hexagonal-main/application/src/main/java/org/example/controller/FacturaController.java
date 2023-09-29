package org.example.controller;

import org.exemple.data.FacturaDTO;
import org.exemple.data.FacturaTotalDTO;
import org.exemple.data.FacturaTotalSubTotalDTO;
import org.exemple.data.request.FacturaDTORequest;
import org.exemple.data.response.FacturaDTOResponse;
import org.exemple.ports.api.FacturaServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/factura")
public class FacturaController {
    private final FacturaServicePort facturaServicePort;

    public FacturaController(FacturaServicePort facturaServicePort) {
        this.facturaServicePort = facturaServicePort;
    }
    @PostMapping("/add")
    public ResponseEntity<FacturaDTOResponse> addFactura(@RequestBody FacturaDTORequest facturaDTORequest){
        FacturaDTOResponse facturaDTOResponse = new FacturaDTOResponse();
        facturaDTOResponse = facturaServicePort.addFactura(facturaDTORequest);
        if(facturaDTOResponse != null) {
            return new ResponseEntity<FacturaDTOResponse>(facturaDTOResponse, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<FacturaDTOResponse>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping ("/update")
    public ResponseEntity<FacturaDTOResponse> updateFactura(@RequestBody FacturaDTORequest facturaDTORequest){
        FacturaDTOResponse facturaDTOResponse = new FacturaDTOResponse();
        facturaDTOResponse = facturaServicePort.updateFactura(facturaDTORequest);
        if(facturaDTOResponse != null) {
            return new ResponseEntity<FacturaDTOResponse>(facturaDTOResponse, HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<FacturaDTOResponse>(facturaDTOResponse, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get")
    public ResponseEntity<List<FacturaDTO>> getFactura( ){
        List<FacturaDTO> listFacturaDTOResponse = new ArrayList<>();
        listFacturaDTOResponse = facturaServicePort.getFacturasList();
        if(listFacturaDTOResponse != null) {
            return new ResponseEntity<List<FacturaDTO>>(listFacturaDTOResponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<List<FacturaDTO>>(listFacturaDTOResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<FacturaDTOResponse> getByIdFactura(@PathVariable Integer id){
        FacturaDTOResponse facturaDTOResponse = new FacturaDTOResponse();
        facturaDTOResponse = facturaServicePort.getFacturaDTOById(id);
        if(facturaDTOResponse != null) {
            return new ResponseEntity<FacturaDTOResponse>(facturaDTOResponse, HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<FacturaDTOResponse>(facturaDTOResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFactura(@PathVariable Integer id){
        facturaServicePort.removeFactura(id);
    }
    @GetMapping("/{facturaId}/total")
    public ResponseEntity<List<FacturaTotalSubTotalDTO>>calcularTotalesPorFactura(@PathVariable("facturaId") int facturaId){
       //return ResponseEntity.ok(facturaServicePort.calcularSubtotalYTotalPorFactura(facturaId));
        return  ResponseEntity.ok(facturaServicePort.subotalTotalesPorFactura(facturaId));
    }
    @GetMapping("/{facturaId}/totalfactura")
    public ResponseEntity<List<FacturaTotalDTO>>calcularTotalesPorFactura(@PathVariable("facturaId") Integer facturaId){
        return ResponseEntity.ok(facturaServicePort.calcularTotalesPorFactura(facturaId));
    }
}
