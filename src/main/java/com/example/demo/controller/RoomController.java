package com.example.demo.controller;

import com.example.demo.model.Reservation;
import com.example.demo.model.Room;
import com.example.demo.service.ReservationService;
import com.example.demo.service.RoomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomController {

    protected static final Logger logger = LogManager.getLogger(RoomController.class);
    @Autowired
    private RoomService roomService;

    @GetMapping(value = "/room", produces = "application/json")
    public ResponseEntity<Iterable<Room>> getAllRooms() {

        logger.info("Inside 'getAllRooms'");

        try {
            Iterable<Room> rooms = roomService.findAll();
            return ResponseEntity.ok( rooms);
        } catch (Exception e) {
            return ResponseEntity.ok( Collections.emptyList());
        }

    }

    @PostMapping(value = "/room/available", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Room>> getAvailableRooms(
            @RequestBody final Room room,
            @RequestParam("checkInDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkInDate,
            @RequestParam("checkOutDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOutDate
            ) {

        logger.info("Inside 'getAvailableRooms'");

        List<Room> rooms = roomService.getAvailableRooms(room, checkInDate, checkOutDate);

        return ResponseEntity.ok(rooms) ;

    }
}
