package com.example.demotest.service;

import com.example.demotest.repository.TicketDemoEntityRepository;
import com.example.demotest.model.TicketDemoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketDemoEntityAdapter {
    @Autowired
    private TicketDemoEntityRepository ticketDemoEntityRepository;
    public TicketDemoEntityAdapter(TicketDemoEntityRepository ticketDemoEntityRepository) {
        this.ticketDemoEntityRepository = ticketDemoEntityRepository;
    }
    public TicketDemoEntity addTicket(TicketDemoEntity ticketDemoEntity){
        return ticketDemoEntityRepository.save(ticketDemoEntity);
    }
    public TicketDemoEntity updateTicket(TicketDemoEntity ticketDemoEntity){
        return ticketDemoEntityRepository.save(ticketDemoEntity);
    }
    public List<TicketDemoEntity> get(){
        return ticketDemoEntityRepository.findAll();
    }
    public TicketDemoEntity getById(Integer id){
        Optional<TicketDemoEntity> ticketId = ticketDemoEntityRepository.findById(id);
        if(ticketId.isPresent())
            return ticketId.get();
        else
            throw new IllegalStateException("This is example of IllegalStateException");
    }
    public void removeTicket(Integer id){
        ticketDemoEntityRepository.deleteById(id);
    }
}
