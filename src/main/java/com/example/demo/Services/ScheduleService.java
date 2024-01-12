package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.IServices.IScheduleService;
import com.example.demo.entities.Schedule;
import com.example.demo.repositories.IScheduleRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ScheduleService implements IScheduleService {

    @Autowired
    private IScheduleRepository scheduleRepository;

    @Autowired 
    private MovieService movieService;

    @Autowired 
    private RoomService roomService;

    @Override
    public List<Schedule> findAllByMovieId(Integer movieId) {
        return scheduleRepository.findAllByMovieId(movieId);
    }

    @Override
    public List<String> getStartTimes(Integer movieId, LocalDate startDate) {
        // if(scheduleRepository.getStartTimeByMovie_IdAndStartDate(movieId, startDate).size() == 0){
        //     System.out.println("buoc3");
        //     return new ArrayList<String>();
        // }
            return (scheduleRepository.getStartTimeByMovie_IdAndStartDate(movieId, startDate))
                .stream().filter(Objects::nonNull)
                .map(localTime -> localTime.format(DateTimeFormatter.ofPattern("HH:mm")))
                .collect(Collectors.toList());  
    }

    @Override
    public Schedule getSchedules(Integer movieId, String startDate, String startTime) {
        return scheduleRepository.findSchedulesByMovie_IdAndStartDateAndStartTime(
                 movieId ,LocalDate.parse(startDate),LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm")));
    }

    @Override
    public List<LocalDate> getStartDate(Integer movieId) {
        return scheduleRepository.getStartDateByMovie_Id(movieId);
    }

    @Override
    @Transactional
    public void deleteById(Integer scheduleId) {
        scheduleRepository.deleteById(scheduleId);
    }

    @Override
    @Transactional
    public void deleteBystartDate(Integer movieId, String startDate) {
        scheduleRepository.deleteByMovie_IdAndStartDate(movieId, LocalDate.parse(startDate));
    }

    @Override
    public Schedule saveNewDate(String date, Integer movieId) throws RuntimeException {
        if(scheduleRepository.getStartDateByMovie_Id(movieId).contains(LocalDate.parse(date))){
            throw new RuntimeException("Ngay bi loi roi!");
        }
        else{
            Schedule newSchedule = new Schedule();
            newSchedule.setMovie(movieService.getMovieById(movieId));
            newSchedule.setStartDate(LocalDate.parse(date));
            return scheduleRepository.save(newSchedule);
        }
    }

    @Override
    public Schedule save(String date, String time, double price, Integer movieId, Integer roomId) {
        Schedule newSchedule = new Schedule();
        newSchedule.setMovie(movieService.getMovieById(movieId));
        newSchedule.setPrice(price);
        newSchedule.setStartDate(LocalDate.parse(date));
        newSchedule.setStartTime(LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm")));
        newSchedule.setRoom(roomService.findRoomById(roomId));
        return scheduleRepository.save(newSchedule);
    }

    @Override
    public List<Schedule> getSchedulesByMovie_IdAndStartDate(Integer movieId, String startDate) {
        return scheduleRepository.getSchedulesByMovie_IdAndStartDate(movieId ,LocalDate.parse(startDate));
    }

        @Override
    public Optional<Schedule> findScheduleByRoomAndTimeAndDate(String date, String time, Integer roomId) {
        return scheduleRepository.findByRoomAndTimeAndDate(
                          LocalDate.parse(date)
                        , LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"))
                        , roomId);
    }
}

