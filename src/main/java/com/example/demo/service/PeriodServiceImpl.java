package com.example.demo.service;

import com.example.demo.repository.PeriodRepository;
import com.example.demo.model.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;

@Service
public class PeriodServiceImpl implements PeriodService{

    PeriodRepository periodRepository;

    @Autowired
    public PeriodServiceImpl(PeriodRepository periodRepository){
      this.periodRepository = periodRepository;
    }

    @Override
    public Period save(Period period){
        return periodRepository.save(period);
    }

    @Override
    public Iterable<Period> saveAll(Iterable<Period> periods){
        return periodRepository.saveAll(periods);
    }

    @Override
    public Optional<Period> findById(Long id){
        return periodRepository.findById(id);
    }

    @Override
    public Iterable<Period> findByRoomType(String roomType) {
        return periodRepository.findByRoomType( roomType);
    }

    @Override
    public boolean existsById(Long id){
        return periodRepository.existsById(id);
    }

    @Override
    public Iterable<Period> findAll(){
        return periodRepository.findAll();
    }

    @Override
    public Iterable<Period> findAllById(Iterable<Long> ids){
        return periodRepository.findAllById(ids);
    }

    @Override
    public long count(){
        return periodRepository.count();
    }

    @Override
    public void deleteById(Long id){
        periodRepository.deleteById(id);
    }

    @Override
    public void delete(Period period){
        periodRepository.delete(period);
    }

    @Override
    public void deleteAll(Iterable<? extends Period> periods){
        periodRepository.deleteAll(periods);
    }

    @Override
    public void deleteAll(){
        periodRepository.deleteAll();
    }

}

