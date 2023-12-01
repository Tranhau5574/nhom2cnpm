package com.example.demo.IServices;

import java.util.List;

import com.example.demo.entities.Ticket;

public interface ITicketService {
    List<Ticket> getTicketsByUserId(Integer userId);
}
