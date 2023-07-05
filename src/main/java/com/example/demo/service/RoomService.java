package com.example.demo.service;

import com.example.demo.model.Room;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RoomService {

    Room save(Room room);

    Iterable<Room> saveAll(Iterable<Room> rooms);

    Optional<Room> findById(Long id);

    Iterable<Room> findAll();

    void deleteById(Long id);

    List<Room> getAvailableRooms(Room room, LocalDate checkInDate, LocalDate checkOutDate);

    Room findByRoomNumber(int roomNumber);
}
