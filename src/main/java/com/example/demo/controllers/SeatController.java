package com.example.demo.controllers;

import com.example.demo.DTOs.SeatDTO;
import com.example.demo.IServices.ISeatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
@CrossOrigin("*")
@RequestMapping("/user/seats")
public class SeatController {
    @Autowired
    private ISeatService seatService;

    @GetMapping
    public String getSeatsByScheduleId(HttpServletRequest request, Model model){

        Integer scheduleId = Integer.parseInt(request.getParameter("scheduleId"));
        List<SeatDTO> listSeatFiltered = seatService.getSeatsByScheduleId(scheduleId);
    
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
