package com.example.demo.repository;

import com.example.demo.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    Iterable<Reservation> findReservationByCheckOutDateAfterAndCheckInDateBefore(LocalDate checkInDate, LocalDate checkOutDate);

}

