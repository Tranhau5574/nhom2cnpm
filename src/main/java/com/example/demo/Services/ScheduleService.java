package com.example.demo.Services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.IServices.IScheduleService;
import com.example.demo.entities.Schedule;
import com.example.demo.reporitories.IScheduleRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService implements IScheduleService {
    @Autowired
    private IScheduleRepository scheduleRepository;
    @Override
    public List<String> getStartTimes(Integer movieId, LocalDate startDate) {
        return scheduleRepository.getStartTimeByMovie_IdAndStartDate(movieId, startDate)
                .stream().map(localTime -> localTime.format(DateTimeFormatter.ofPattern("HH:mm")))
                .collect(Collectors.toList());
    }
}