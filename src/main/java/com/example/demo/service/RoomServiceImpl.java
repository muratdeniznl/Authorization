package com.example.demo.service;

import com.example.demo.model.Reservation;
import com.example.demo.model.Room;
import com.example.demo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    ReservationService reservationService;

    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Iterable<Room> saveAll(Iterable<Room> rooms) {
        return roomRepository.saveAll( rooms);
    }

    @Override
    public Optional<Room> findById(Long id) {
        return roomRepository.findById( id);
    }

    @Override
    public Iterable<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        roomRepository.deleteById( id);
    }

    @Override
    public List<Room> getAvailableRooms(Room criteria, LocalDate checkInDate, LocalDate checkOutDate) {

        Iterable<Reservation> reservations = reservationService.findReservationByCheckOutDateAfterAndCheckInDateBefore(checkInDate, checkOutDate);

        List<Long> roomIds = new ArrayList<>();

        for(Reservation reservation: reservations){
            roomIds.add(reservation.getRoom().getId());
        }

        Iterable<Room> allRooms = roomRepository.findAll();

        List<Room> availableRooms = new ArrayList<>();

        for( Room room: allRooms){

            if(roomIds.contains(room.getId() )){
                continue;
            }
            if( criteria.isDisabled() != room.isDisabled()){
                continue;
            }
            if( criteria.isSmoking() != room.isSmoking()){
                continue;
            }
            if( criteria.getBeds() > 0 && criteria.getBeds() > room.getBeds()){
                continue;
            }
            availableRooms.add( room);
        }

        return availableRooms;

    }

    @Override
    public Room findByRoomNumber(int roomNumber) {
        return roomRepository.findByRoomNumber( roomNumber);
    }

}
