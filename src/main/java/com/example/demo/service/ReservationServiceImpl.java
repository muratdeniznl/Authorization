package com.example.demo.service;

import com.example.demo.repository.ReservationRepository;
import com.example.demo.model.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{

    ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository){
      this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation save(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    @Override
    public Iterable<Reservation> saveAll(Iterable<Reservation> reservations){
        return reservationRepository.saveAll(reservations);
    }

    @Override
    public Optional<Reservation> findById(Long id){
        return reservationRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id){
        return reservationRepository.existsById(id);
    }

    @Override
    public Iterable<Reservation> findAll(){
        return reservationRepository.findAll();
    }

    @Override
    public Iterable<Reservation> findAllById(Iterable<Long> ids){
        return reservationRepository.findAllById(ids);
    }

    @Override
    public long count(){
        return reservationRepository.count();
    }

    @Override
    public void deleteById(Long id){
        reservationRepository.deleteById(id);
    }

    @Override
    public void delete(Reservation reservation){
        reservationRepository.delete(reservation);
    }

    @Override
    public void deleteAll(Iterable<? extends Reservation> reservations){
        reservationRepository.deleteAll(reservations);
    }

    @Override
    public void deleteAll(){
        reservationRepository.deleteAll();
    }

    @Override
    public Iterable<Reservation> findReservationByCheckOutDateAfterAndCheckInDateBefore(LocalDate checkInDate, LocalDate checkOutDate) {
        return reservationRepository.findReservationByCheckOutDateAfterAndCheckInDateBefore(checkInDate, checkOutDate);
    }

}

