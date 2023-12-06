package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.IServices.ITicketService;
import com.example.demo.entities.Ticket;
import com.example.demo.repositories.ITicketRepository;

import java.util.List;

@Service
public class TicketService implements ITicketService{
    @Autowired
    private ITicketRepository ticketRepository;
    @Override
    public List<Ticket> getTicketsByUserId(Integer userId) {
        return ticketRepository.findTicketsByUserId(userId);
    }
}
