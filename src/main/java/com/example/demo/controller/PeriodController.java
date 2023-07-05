package com.example.demo.controller;

import java.util.Collections;
import java.util.Iterator;

import com.example.demo.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Period;

@RestController
@RequestMapping("/api")
public class PeriodController {

    protected static final Logger logger = LogManager.getLogger();

    private PeriodService periodService;
    
    @Autowired
    public PeriodController(PeriodService periodService){
        this.periodService = periodService;

    }

    @PutMapping(value = "/period", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Period> savePeriod( @RequestBody final Period period) {

        logger.info("Inside 'savePeriodById'");

        periodService.save(period);
        return ResponseEntity.ok(period) ;

    }

    @GetMapping(value = "/period/{id}", produces = "application/json")
    public ResponseEntity<Period> getPeriodById( @PathVariable final Long id) {

        logger.info("Inside 'getPeriodById'");

        try {
            Period period = periodService.findById(id).orElse(null);
            return ResponseEntity.ok( period);
        } catch (Exception e) {
            return ResponseEntity.ok( null);
        }

    }
    @GetMapping(value = "/periodsbyroomtype/{roomType}", produces = "application/json")
    public ResponseEntity<Iterable<Period>> getPeriodsByRoomType(@PathVariable final String roomType) {

        logger.info("Inside 'getPeriodsByRoomType'");

        Iterable<Period> periods = periodService.findByRoomType( roomType);
        return ResponseEntity.ok( periods);
    }

    @GetMapping(value = "/period", produces = "application/json")
    public ResponseEntity<Iterable<Period>> getAllPeriods() {

        logger.info("Inside 'getAllPeriods'");

        try {
            Iterable<Period> periods = periodService.findAll();
            return ResponseEntity.ok( periods);
        } catch (Exception e) {
            return ResponseEntity.ok( Collections.emptyList());
        }

    }

    @DeleteMapping(value = "/period/{id}", produces = "text/plain")
    public ResponseEntity<String> deletePeriodById( @PathVariable final Long id) {

        logger.info("Inside 'deletePeriodById'");

        try {
            periodService.deleteById(id);
            return ResponseEntity.ok( "Item with id: " + id + " is deleted");
        } catch (Exception e) {
            return ResponseEntity.ok( "Item with id: " + id + " may NOT be deleted");
        }

    }

}

