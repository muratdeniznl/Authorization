package com.example.demo.service;

import com.example.demo.model.Period;

import java.util.Iterator;
import java.util.Optional;

public interface PeriodService {

    Period save(Period period);

    Iterable<Period> saveAll(Iterable<Period> periods);

    Optional<Period> findById(Long id);

    public Iterable<Period> findByRoomType(String roomType);

    boolean existsById(Long id);

    Iterable<Period> findAll();

    Iterable<Period> findAllById(Iterable<Long> ids);

    long count();

    void deleteById(Long id);

    void delete(Period period);

    void deleteAll(Iterable<? extends Period> periods);

    void deleteAll();

}

