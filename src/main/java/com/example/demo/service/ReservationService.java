package com.example.demo.service;

import com.example.demo.model.Reservation;

import java.time.LocalDate;
import java.util.Optional;

public interface ReservationService {

    public Reservation save(Reservation reservation);

    public Iterable<Reservation> saveAll(Iterable<Reservation> reservations);

    public Optional<Reservation> findById(Long id);

    public boolean existsById(Long id);

    public Iterable<Reservation> findAll();

    public Iterable<Reservation> findAllById(Iterable<Long> ids);

    public long count();

    public void deleteById(Long id);

    public void delete(Reservation reservation);

    public void deleteAll(Iterable<? extends Reservation> reservations);

    public void deleteAll();

    public Iterable<Reservation> findReservationByCheckOutDateAfterAndCheckInDateBefore(LocalDate checkInDate, LocalDate checkOuDate);

}

