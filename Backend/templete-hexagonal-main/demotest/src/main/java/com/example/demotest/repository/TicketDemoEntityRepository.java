package com.example.demotest.repository;


import com.example.demotest.model.TicketDemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketDemoEntityRepository extends JpaRepository<TicketDemoEntity, Integer> {
}
