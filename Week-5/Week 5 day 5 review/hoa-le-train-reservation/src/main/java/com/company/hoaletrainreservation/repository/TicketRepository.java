package com.company.hoaletrainreservation.repository;

import com.company.hoaletrainreservation.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
