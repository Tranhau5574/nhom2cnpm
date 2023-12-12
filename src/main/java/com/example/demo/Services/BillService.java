package com.example.demo.Services;

import com.example.demo.IServices.IBillService;
import com.example.demo.entities.Bill;
import com.example.demo.entities.Schedule;
import com.example.demo.entities.Ticket;
import com.example.demo.entities.User;
import com.example.demo.repositories.IBillRepository;
import com.example.demo.repositories.IScheduleRepository;
import com.example.demo.repositories.ISeatRepository;
import com.example.demo.repositories.ITicketRepository;
import com.example.demo.security.repo.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BillService implements IBillService{
    @Autowired
    private ITicketRepository ticketRepository;
    @Autowired
    private ISeatRepository seatRepository;
    @Autowired
    private IBillRepository billRepository;

    @Override
    @Transactional
    public void createNewBills(Schedule schedule, User user, List<Integer> listSelectedSeatIds) throws RuntimeException {
        //Lưu Bill gồm thông tin người dùng xuống trước
        Bill billToCreate = new Bill();
        billToCreate.setUser(user);
        billToCreate.setCreatedTime(LocalDateTime.now());
        Bill createdBill = billRepository.save(billToCreate);

        //Với mỗi ghế ngồi check xem đã có ai đặt chưa, nếu rồi thì throw, roll back luôn còn ko
        //thì đóng gói các thông tin ghế và lịch vào vé và lưu xuống db
        listSelectedSeatIds.forEach(seatId->{
            if(!ticketRepository.findTicketsBySchedule_IdAndSeat_Id(schedule.getId(),seatId)
                    .isEmpty()){// Nếu đã có người đặt vé ghế đó ở lịch cụ thể đó thì
                throw new RuntimeException("Đã có người nhanh tay hơn đặt ghế, mời bạn chọn lại!");
            }
            // đóng gói lịch, seat và bill vào từng vé rồi add vào list vé
            Ticket ticket = new Ticket();
            ticket.setSchedule(schedule);
            ticket.setSeat(seatRepository.getById(seatId));
            ticket.setBill(createdBill);
            ticket.setQrImageURL("https://scontent-sin6-2.xx.fbcdn.net/v/t1.15752-9/268794058_655331555823095_3657556108194277679_n.png?_nc_cat=105&ccb=1-5&_nc_sid=ae9488&_nc_ohc=BrNXGO8HufkAX_OGjWc&_nc_ht=scontent-sin6-2.xx&oh=03_AVK_zaJj7pziY9nLrVqoIQJAzbomu4KPgED1PxFFpYfCrQ&oe=61F778D8");
            ticketRepository.save(ticket);

            createdBill.setTotalprice(schedule.getPrice() * listSelectedSeatIds.size());
        });

    }
}
