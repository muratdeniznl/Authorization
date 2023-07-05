package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Value("${server.port}")
	String port;

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	RoomRepository roomRepository;
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	PeriodRepository periodRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Customer> customers = new ArrayList<>();

		for( int n = 0; n < 150; n++){
			customers.add( new Customer(0, Util.getFakeFullName(), Util.getFakeAddress(), Util.getFakeAge()));
		}

		customerRepository.saveAll( customers);

		runTestSet();

		System.out.println("http://localhost:" + port + "/swagger-ui/index.html");
		System.out.println("http://localhost:" + port + "/h2-console");
	}
	private void runTestSet01() {

		Room room;

		room = saveRoom( 301,2, true, false, true, "Single");
		roomRepository.save(room);
		saveReservation( 1, room);

		room = saveRoom( 302,4, false, true, false, "Double");
		roomRepository.save(room);
		saveReservation( 1, room);

		periodRepository.save( getPeriod( 20,"Single"));
		periodRepository.save( getPeriod( 25,"Double"));
		periodRepository.save( getPeriod( 30,"Penthouse"));

	}

	private Period getPeriod(double percentage, String roomType) {

		LocalDate checkInDate = LocalDate.now().plus(java.time.Period.ofDays(1));
		LocalDate checkOutDate = LocalDate.now().plus(java.time.Period.ofDays(1));

		return new Period(roomType, percentage, checkInDate, checkOutDate);
	}

	private void runTestSet() {
		Room room;

		String SINGLE = "Single";
		String DOUBLE = "Double";
		//RoomType roomType = new RoomType("Double", discount20);
		//  roomTypeRepository.save(roomType);
		saveRoom( 201,2, false, true, true, SINGLE);
		saveRoom( 202,2,false, false, false, DOUBLE);
		saveRoom( 203,2,true, true, true, SINGLE);
		saveRoom( 205,2,false, false, false, DOUBLE);
		saveRoom( 205,4,true, false, true, SINGLE);
		saveRoom( 206,4,false, false, false, DOUBLE);
		saveRoom( 207,4,true, true, true, SINGLE);
		saveRoom( 208,4,false, false, true, DOUBLE);

		room = saveRoom( 209, 3,true, true, false, SINGLE);
		saveReservation( 1, room);
		saveReservation( 7, room);
		saveReservation( 12, room);

		room = saveRoom( 210, 1,false, true, true, DOUBLE);
		saveReservation( 1, room);
		saveReservation( 7, room);
		saveReservation( 12, room);

		room = saveRoom( 211,4,false, false, false, DOUBLE);
		saveReservation( 1, room);
		saveReservation( 7, room);
		saveReservation( 12, room);

		room = saveRoom( 212,2,true, false, true, SINGLE);
		saveReservation( 1, room);
		saveReservation( 7, room);
		saveReservation( 12, room);

		saveRoom( 213,3,true, false, true, DOUBLE);
		saveRoom( 214,3,false, false, false, SINGLE);
		saveRoom( 215,5,true, true, true, DOUBLE);
		saveRoom( 216,5,false, true, false, SINGLE);

		periodRepository.save( getPeriod( 20,"Single"));
		periodRepository.save( getPeriod( 25,"Double"));
		periodRepository.save( getPeriod( 30,"Penthouse"));
	}

	private void saveReservation(int offset, Room room) {
		Reservation reservation = new Reservation();
		reservation.setCheckInDate( LocalDate.now().plus(java.time.Period.ofDays(offset)));
		reservation.setCheckOutDate( LocalDate.now().plus(java.time.Period.ofDays(offset + 3)));
		reservation.setRoom( room);
		reservationRepository.save(reservation);
	}


	private Room saveRoom(int r, int i, boolean b, boolean b1, boolean s, String roomType) {

		Room room = new Room(r, i, b, b1, s, roomType);
		roomRepository.save(room);
		return room;
	}


}
