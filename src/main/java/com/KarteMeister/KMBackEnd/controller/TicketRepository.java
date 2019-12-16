package com.KarteMeister.KMBackEnd.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.KarteMeister.KMBackEnd.domein.Ticket;

@Component
public interface TicketRepository extends CrudRepository<Ticket, Long> {

}
