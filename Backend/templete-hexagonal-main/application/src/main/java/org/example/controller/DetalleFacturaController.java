package org.example.controller;

import org.exemple.data.DetallefacturaDTO;
import org.exemple.data.request.DetallefacturaDTORequest;
import org.exemple.data.response.DetallefacturaDTOResponse;
import org.exemple.ports.api.DetalleFacturaServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/detallefactura")
public class DetalleFacturaController {
    private final DetalleFacturaServicePort detallefacturaServicePort;

    public DetalleFacturaController(DetalleFacturaServicePort detallefacturaServicePort) {
        this.detallefacturaServicePort = detallefacturaServicePort;
    }
    @PostMapping("/add")
    public ResponseEntity<DetallefacturaDTOResponse> addDetallefactura(@RequestBody DetallefacturaDTORequest detallefacturaDTORequest){
        DetallefacturaDTOResponse detallefacturaDTOResponse = new DetallefacturaDTOResponse();
        detallefacturaDTOResponse = detallefacturaServicePort.addDetalleFactura(detallefacturaDTORequest);
        if(detallefacturaDTOResponse != null) {
            return new ResponseEntity<DetallefacturaDTOResponse>(detallefacturaDTOResponse, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<DetallefacturaDTOResponse>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping ("/update")
    public ResponseEntity<DetallefacturaDTOResponse> updateDetallefactura(@RequestBody DetallefacturaDTORequest detallefacturaDTORequest){
        DetallefacturaDTOResponse detallefacturaDTOResponse = new DetallefacturaDTOResponse();
        detallefacturaDTOResponse = detallefacturaServicePort.updateDetalleFactura(detallefacturaDTORequest);
        if(detallefacturaDTOResponse != null) {
            return new ResponseEntity<DetallefacturaDTOResponse>(detallefacturaDTOResponse, HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<DetallefacturaDTOResponse>(detallefacturaDTOResponse, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get")
    public ResponseEntity<List<DetallefacturaDTO>> getDetallefactura( ){
        List<DetallefacturaDTO> listDetallefacturaDTOResponse = new ArrayList<>();
        listDetallefacturaDTOResponse = detallefacturaServicePort.getDetalleFacturasList();
        if(listDetallefacturaDTOResponse != null) {
            return new ResponseEntity<List<DetallefacturaDTO>>(listDetallefacturaDTOResponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<List<DetallefacturaDTO>>(listDetallefacturaDTOResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<DetallefacturaDTOResponse> getByIdDetallefactura(@PathVariable Integer id){
        DetallefacturaDTOResponse detallefacturaDTOResponse = new DetallefacturaDTOResponse();
        detallefacturaDTOResponse = detallefacturaServicePort.getDetalleFacturaDTOById(id);
        if(detallefacturaDTOResponse != null) {
            return new ResponseEntity<DetallefacturaDTOResponse>(detallefacturaDTOResponse, HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<DetallefacturaDTOResponse>(detallefacturaDTOResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDetallefactura(@PathVariable Integer id){
        detallefacturaServicePort.removeDetalleFactura(id);
    }

    @GetMapping("/{codigoFactura}/total")
    public ResponseEntity<Double> calcularTotalPorCodigoFactura(@PathVariable("codigoFactura") int codigoFactura) {
        Double total = detallefacturaServicePort.calcularTotalPorCodigoFactura(codigoFactura);
        return ResponseEntity.ok(total);
    }
}
