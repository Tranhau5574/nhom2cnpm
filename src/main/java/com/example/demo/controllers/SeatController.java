package com.example.demo.controllers;

import com.example.demo.DTOs.SeatDTO;
import com.example.demo.IServices.ISeatService;
import com.example.demo.Services.ScheduleService;
import com.example.demo.entities.Schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin("*")
@RequestMapping("/user/seats")
public class SeatController {
    @Autowired
    private ISeatService seatService;

    @Autowired 
    private ScheduleService scheduleService;

    @GetMapping
    public String displaySeatChoosing(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Integer movieId = (Integer)session.getAttribute("movieId");
        String chosenDate = (String)session.getAttribute("chosenDate");
        String chosenTime = request.getParameter("chosenTime");
        Schedule chosenSchedule = scheduleService.getSchedules(movieId, chosenDate, chosenTime);
        session.setAttribute("chosenSchedule", chosenSchedule);

        List<SeatDTO> listSeatFiltered = seatService.getSeatsByScheduleId(chosenSchedule.getId());
    
        SeatDTO[] listSeatDTOS = new SeatDTO[listSeatFiltered.size()];
        for(int i = 0; i < listSeatFiltered.size(); i++){
            listSeatDTOS[i] = listSeatFiltered.get(i);
        }
        SeatDTO[] listA = new SeatDTO[8];
        SeatDTO[] listB = new SeatDTO[8];
        SeatDTO[] listC = new SeatDTO[8];
        SeatDTO[] listD = new SeatDTO[8];
        SeatDTO[] listE = new SeatDTO[8];
        for(int i=0;i<=7;i++){
            listA[i]=listSeatDTOS[i];
            listB[i]=listSeatDTOS[i+8];
            listC[i]=listSeatDTOS[i+16];
            listD[i]=listSeatDTOS[i+24];
            listE[i]=listSeatDTOS[i+32];
        }
        model.addAttribute("listA",listA);
        model.addAttribute("listB",listB);
        model.addAttribute("listC",listC);
        model.addAttribute("listD",listD);
        model.addAttribute("listE",listE);

        return "seat";
    }
}
