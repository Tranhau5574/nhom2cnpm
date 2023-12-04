package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.IServices.ISeatService;
import com.example.demo.entities.Room;
import com.example.demo.entities.Seat;
import com.example.demo.reporitories.IScheduleRepository;
import com.example.demo.reporitories.ISeatRepository;
import com.example.demo.reporitories.ITicketRepository;

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

    @Override
    public List<Seat> getSeatsByScheduleId(Integer scheduleId) {
        // Lấy ra các chỗ ngồi của phòng trong lịch đó
        Room room = scheduleRepository.getById(scheduleId).getRoom();
        List<Seat> listSeat = seatRepository.getSeatByRoom_Id(room.getId());

        // Lấy ra các vé đã được đặt trong lịch đó rồi map sang các chỗ ngồi
        List<Seat> occupiedSeats = ticketRepository.findTicketsBySchedule_Id(scheduleId)
                .stream().map(ticket -> ticket.getSeat())
                .collect(Collectors.toList());

        // Map list chỗ ngồi của phòng ở bước 1 sang list dto
        List<SeatDTO> filteredSeats = listSeat.stream().map(seat -> {
           SeatDTO seatDTO = modelMapper.map(seat,SeatDTO.class);
           if(occupiedSeats.stream()
                   .map(occupiedSeat->occupiedSeat.getId())
                   .collect(Collectors.toList())
                   .contains(seat.getId())
            ){
                seatDTO.setIsOccupied(1); // Nếu ghế nào nằm trong list ghế đã được occupied thì set = 1
            }
           return seatDTO;
        }).collect(Collectors.toList());

        return  filteredSeats;
    }
}
