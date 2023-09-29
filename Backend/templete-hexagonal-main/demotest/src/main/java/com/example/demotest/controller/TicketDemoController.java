package com.example.demotest.controller;

import com.example.demotest.model.TicketDemo;
import com.example.demotest.model.TicketDemoEntity;
import com.example.demotest.service.TicketDemoEntityAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ticketDemo")
public class TicketDemoController {

    @Autowired
    private TicketDemoEntityAdapter ticketDemoEntityAdapter;
    @GetMapping("/get")
    public ResponseEntity<List<TicketDemoEntity>> getTicket( ){
        List<TicketDemoEntity> listTicketDTOResponse = new ArrayList<>();
        listTicketDTOResponse = ticketDemoEntityAdapter.get();
        if(listTicketDTOResponse != null) {
            return new ResponseEntity<List<TicketDemoEntity>>(listTicketDTOResponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<List<TicketDemoEntity>>(listTicketDTOResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/ticket/{id}")
    public ResponseEntity<TicketDemoEntity> getOrderById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(ticketDemoEntityAdapter.getById(id));
    }
    @PostMapping(path = "/create")
    public ResponseEntity<TicketDemoEntity> saveCustomer(@RequestBody TicketDemoEntity ticketDemoEntity) {
        TicketDemoEntity newOrder = ticketDemoEntityAdapter.addTicket(ticketDemoEntity);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }
    @PostMapping(path = "/update")
    public ResponseEntity<TicketDemoEntity> updateCustomer(@RequestBody TicketDemoEntity ticketDemoEntity) {
        TicketDemoEntity newOrder = ticketDemoEntityAdapter.updateTicket(ticketDemoEntity);
        return new ResponseEntity<>(newOrder, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteTicket(@PathVariable Integer id){
        ticketDemoEntityAdapter.removeTicket(id);
    }
}
