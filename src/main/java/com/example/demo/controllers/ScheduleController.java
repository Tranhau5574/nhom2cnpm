package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Services.MovieService;
import com.example.demo.Services.RoomService;
import com.example.demo.Services.ScheduleService;
import com.example.demo.entities.Schedule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Controller
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @Autowired
    MovieService movieService;

    @Autowired
    RoomService roomService;
    
    @RequestMapping(value = "/user/chooseDate", method = RequestMethod.GET)
    public String displayDatePage(@RequestParam Integer movieId, Model model, HttpServletRequest request){

        //Thêm movieId vào session để dùng sau
        HttpSession session = request.getSession();
        session.setAttribute("movieId", movieId);

        // Để tạm ngày hôm nay
        LocalDate.now();
        LocalDate today = LocalDate.now();
        ArrayList<LocalDate> listDates = new ArrayList<>();
        listDates.add(today);
        // Lấy ra 10 ngày tính từ hôm nay để hiện trong trang chọn ngày
        for(int i=1;i<=9;i++){
            today = today.plusDays(1);
            listDates.add(today);
        }

        model.addAttribute("listDates",listDates);
        return "date";
    }

    @RequestMapping(value = "/user/chooseDate", method = RequestMethod.POST)
    public String displayTimePage(Model model, HttpServletRequest request){
        
        HttpSession session = request.getSession();
        Integer movieId = (Integer)session.getAttribute("movieId");
        String chosenDate = request.getParameter("chosenDate");
        session.setAttribute("chosenDate", chosenDate);

        List<String> listStartTimes = scheduleService.getStartTimes(
                                      movieId,LocalDate.parse(chosenDate));
        model.addAttribute("listStartTimes", listStartTimes);
        return "time";
    }

    @RequestMapping(value = "/admin/schedule/deleteDate", method = RequestMethod.GET)
    public String deleteDate(@RequestParam("movieId") Integer movieId, @RequestParam("date") String date){
        scheduleService.deleteBystartDate(movieId,date);
        return "redirect:/admin/schedule?movieId=" + movieId;
    }
        
    @RequestMapping(value = "/admin/schedule/addDate", method = RequestMethod.POST)
    public String addDate(@RequestParam("movieId") Integer movieId
                        , @RequestParam("date") String date){
        String error = "";
        try {
            Schedule newSchedule = scheduleService.saveNewDate(date, movieId);
        } catch (RuntimeException e) {
            error = "error_1";
        }
        return "redirect:/admin/schedule?movieId=" + movieId + "&error=" + error;
    }

    @RequestMapping(value = "/admin/schedule/time", method = RequestMethod.GET)
    public String showTime(@RequestParam("movieId") Integer movieId
                        , @RequestParam("date") String date
                        , @RequestParam(value = "error", defaultValue = "") String error
                        , Model model){

        List<Schedule> listSchedules = scheduleService.getSchedulesByMovie_IdAndStartDate(movieId, date);
        model.addAttribute("listSchedules",listSchedules);
        model.addAttribute("movie", movieService.getMovieById(movieId));
        model.addAttribute("date", date);
        model.addAttribute("listRoom", roomService.findAllRoom());
        if(error.equals("error_2")){
            model.addAttribute("errorMessage", "Đã tồn tại giờ chiếu(Tại 1 thời điểm, 1 phim chỉ được chiếu tại 1 phòng :3");
        }
        else if(error.equals("error_3")){
            model.addAttribute("errorMessage", "Phòng đã có phim chiếu vào thời gian này");
        }
        return "admin-time-room";
    }

    @RequestMapping(value = "/admin/schedule/time", method = RequestMethod.POST)
    public String addTime(@RequestParam("movieId") Integer movieId
                        , @RequestParam("date") String date
                        , @RequestParam("roomId") Integer roomId
                        , @RequestParam("time") String time
                        , @RequestParam("price") double price
                        , Model model){

        String error = "";
        List<String> listStartTime = scheduleService.getStartTimes(movieId, LocalDate.parse(date));
        System.out.println("buoc4");
        Optional<Schedule> scheduleAtTheTimeAndRoom = scheduleService.findScheduleByRoomAndTimeAndDate(date, time, roomId);    
        System.out.println("buoc5");
        if(listStartTime.contains(time)){
            System.out.println("Đã tồn tại giờ chiếu(Tại 1 thời điểm, 1 phim chỉ được chiếu tại 1 phòng :3");
            error = "error_2";
        }
        if (scheduleAtTheTimeAndRoom.isPresent()) {
            error = "error_3";
        }
        else{
            //CHECKING...//
            Schedule newSchedule = scheduleService.save(date, time, price, movieId, roomId);
        }
        return "redirect:/admin/schedule/time?movieId="+ movieId + "&date=" + date + "&error=" + error ;                   
    }

    @RequestMapping(value = "/admin/schedule/time/delete", method = RequestMethod.GET)
    public String deleteTime( @RequestParam("scheduleId") Integer scheduleId
                            , @RequestParam("movieId") Integer movieId
                            , @RequestParam("date") String date){
        scheduleService.deleteById(scheduleId);
        return "redirect:/admin/schedule/time?movieId="+ movieId + "&date=" + date;
    }
}
