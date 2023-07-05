package com.example.demo.repository;

import com.example.demo.model.Period;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;

@Repository
public interface PeriodRepository extends CrudRepository<Period, Long> {

    Iterable<Period> findByRoomType( String roomType);
}

