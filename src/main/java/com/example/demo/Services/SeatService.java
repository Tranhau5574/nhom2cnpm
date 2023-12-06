package com.example.demo.Services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTOs.SeatDTO;
import com.example.demo.IServices.ISeatService;
import com.example.demo.entities.Room;
import com.example.demo.entities.Seat;
import com.example.demo.repositories.IScheduleRepository;
import com.example.demo.repositories.ISeatRepository;
import com.example.demo.repositories.ITicketRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatService implements ISeatService{
    @Autowired
    private ISeatRepository seatRepository;
    @Autowired
    private IScheduleRepository scheduleRepository;
    @Autowired
    private ITicketRepository ticketRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<SeatDTO> getSeatsByScheduleId(Integer scheduleId) {
        // Lấy ra các chỗ ngồi của phòng trong lịch chiếu
        Room room = scheduleRepository.getById(scheduleId).getRoom();
        List<Seat> listSeat = seatRepository.getSeatByRoom_Id(room.getId());

        // Lấy các chỗ ngồi đã được đặt từ danh sách các vé trong lịch chiếu 
        List<Seat> occupiedSeats = ticketRepository.findTicketsBySchedule_Id(scheduleId)
                .stream().map(ticket -> ticket.getSeat())
                .collect(Collectors.toList());

        // Map danh sách seat sang danh sách SeatDTO đã có ghi chú các chỗ ngồi hiện đã bị đặt
        List<SeatDTO> filteredSeats = listSeat.stream().map(seat -> {
            SeatDTO seatDTO = modelMapper.map(seat,SeatDTO.class);
            //Kiểm tra có nằm trong danh sách occupiedSeats
            if(occupiedSeats.stream()
                   .map(occupiedSeat->occupiedSeat.getId())
                   .collect(Collectors.toList())
                   .contains(seat.getId())
            ){
                seatDTO.setIsOccupied(true); 
            }
            else seatDTO.setIsOccupied(false);
            return seatDTO;
        }).collect(Collectors.toList());

        return  filteredSeats;
    }

    @Override
    public String findSeatNameById(Integer seatId) {
        return seatRepository.findSeatNameById(seatId);
    }
}