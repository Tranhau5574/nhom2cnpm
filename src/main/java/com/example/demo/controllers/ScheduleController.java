package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.Services.ScheduleService;
import com.example.demo.entities.Schedule;
import com.example.demo.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;
    
    @RequestMapping(value = "/user/chooseDate", method = RequestMethod.GET)
    public String displayDatePage(@RequestParam Integer movieId, Model model, HttpServletRequest request){
        HttpSession session = request.getSession();

        // Để tạm ngày hôm nay
        LocalDate today = LocalDate.parse("2021-01-05");
        ArrayList<LocalDate> listDates = new ArrayList<>();
        listDates.add(today);
        // Lấy ra 10 ngày tính từ hôm nay để hiện trong trang chọn ngày
        for(int i=1;i<=9;i++){
            today = today.plusDays(1);
            listDates.add(today);
        }

        model.addAttribute("listDates",listDates);
        model.addAttribute("user",new User());
        return "date";
    }

    @RequestMapping(value = "/user/chooseDate", method = RequestMethod.POST)
    public String displayTimePage(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Integer movieId = (Integer)session.getAttribute("movieId");
        String startDate = request.getParameter("startDate");

        List<String> listStartTimes = scheduleService.getStartTimes(movieId,LocalDate.parse(startDate));
        model.addAttribute("listStartTimes", listStartTimes);
        return "time";
    }
}
