package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Services.SeatService;
import com.example.demo.entities.Schedule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/user/bill")
public class BillController {

    @Autowired
    SeatService seatService;

    @PostMapping
    public String displayBillPage(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        //Lấy ra những chỗ ngồi mà khách đặt,map sang list kiểu int rồi lưu lên session
        String[] seatIds = request.getParameterValues("seats");
        List<Integer> listSeatIds = Arrays.stream(seatIds)
                                          .map(seatId->Integer.parseInt(seatId))
                                          .collect(Collectors.toList());
        session.setAttribute("listSelectedSeatIds",listSeatIds);

        // Đếm số ghế và lấy các ghế đã chọn:
        Integer numberOfSelectedSeats= listSeatIds.size();
        model.addAttribute("numberOfSelectedSeats",numberOfSelectedSeats);
        List<String> listSeatNames = listSeatIds.stream()
                                                .map(seatId -> seatService.findSeatNameById(seatId))
                                                .collect(Collectors.toList());
        model.addAttribute("listSeats", listSeatNames);
        
        // Lấy ra tổng tiền:
        Schedule scheduleFromSession = (Schedule)session.getAttribute("chosenSchedule");
        Double totalAmount = scheduleFromSession.getPrice() * numberOfSelectedSeats;
        model.addAttribute("totalAmount",totalAmount);

        // Format lại ngày:
        model.addAttribute("formattedDate",
                scheduleFromSession.getStartDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        session.removeAttribute("bookedError");
        return "bill";
    }

    @GetMapping
    public String createBill(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        Schedule scheduleFromSession = (Schedule)session.getAttribute("chosenSchedule");
        
        List<Integer> listSeatIds = (List<Integer>)session.getAttribute("listSelectedSeatIds");

        String message = "Có người nhanh tay hơn đã chọn vào ghế mà bạn đã đặt, vui lòng chọn lại chỗ ngồi!";
        try {
            billService.createNewBill
        }catch (HttpClientErrorException ex){ // Nếu đã có người đặt ghế nhanh hơn thì quay lại trang chọn ghế
                message = ex.getResponseBodyAsString();
                session.setAttribute("bookedError",message);
                return "redirect:/user/seats?movieId=" + scheduleFromSession.getMovie().getId()
                        + "&branchId=+" + scheduleFromSession.getBranch().getId() + "&startDate="
                        + scheduleFromSession.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "&startTime="
                        + scheduleFromSession.getStartTime().format(DateTimeFormatter.ofPattern("HH:mm"))      + "&roomId="
                        + scheduleFromSession.getRoom().getId();

        }


        return "redirect:/tickets/history";
    }
}
