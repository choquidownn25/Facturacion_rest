package org.example.controller;

import org.exemple.data.ProductoDTO;
import org.exemple.data.request.ProductoDTORequest;
import org.exemple.data.response.ProductoDTOResponse;
import org.exemple.ports.api.ProductoServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    private final ProductoServicePort productoServicePort;

    public ProductoController(ProductoServicePort productoServicePort) {
        this.productoServicePort = productoServicePort;
    }
    @PostMapping("/add")
    public ResponseEntity<ProductoDTOResponse> addProducto(@RequestBody ProductoDTORequest productoDTORequest){
        ProductoDTOResponse productoDTOResponse = new ProductoDTOResponse();
        productoDTOResponse = productoServicePort.addProducto(productoDTORequest);
        if(productoDTOResponse != null) {
            return new ResponseEntity<ProductoDTOResponse>(productoDTOResponse, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<ProductoDTOResponse>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping ("/update")
    public ResponseEntity<ProductoDTOResponse> updateProducto(@RequestBody ProductoDTORequest productoDTORequest){
        ProductoDTOResponse productoDTOResponse = new ProductoDTOResponse();
        productoDTOResponse = productoServicePort.updateProducto(productoDTORequest);
        if(productoDTOResponse != null) {
            return new ResponseEntity<ProductoDTOResponse>(productoDTOResponse, HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<ProductoDTOResponse>(productoDTOResponse, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get")
    public ResponseEntity<List<ProductoDTO>> getProducto( ){
        List<ProductoDTO> listProductoDTOResponse = new ArrayList<>();
        listProductoDTOResponse = productoServicePort.getProductosList();
        if(listProductoDTOResponse != null) {
            return new ResponseEntity<List<ProductoDTO>>(listProductoDTOResponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<List<ProductoDTO>>(listProductoDTOResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProductoDTOResponse> getByIdProducto(@PathVariable Integer id){
        ProductoDTOResponse productoDTOResponse = new ProductoDTOResponse();
        productoDTOResponse = productoServicePort.getProductoDTOById(id);
        if(productoDTOResponse != null) {
            return new ResponseEntity<ProductoDTOResponse>(productoDTOResponse, HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<ProductoDTOResponse>(productoDTOResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProducto(@PathVariable Integer id){
        productoServicePort.removeProducto(id);
    }
}
