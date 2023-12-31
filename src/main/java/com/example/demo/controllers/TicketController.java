package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Services.TicketService;
import com.example.demo.entities.Ticket;
import com.example.demo.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

@Controller
@RequestMapping("/user/tickets")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/history")
    public String displayHistoryPage(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Integer userId = ((User)session.getAttribute("currentUser")).getId();
        List<Ticket> listTickets = ticketService.getTicketsByUserId(userId);

        model.addAttribute("listTickets",listTickets);

        return "history";
    }
}
