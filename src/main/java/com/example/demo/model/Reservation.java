package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Reservation{

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;

	@ManyToOne
	private Room room;
	private boolean seaView;

	public Reservation() {
	}

	public Reservation(LocalDate checkInDate, LocalDate checkOutDate, Room room, boolean seaView) {
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.room = room;
		this.seaView = seaView;
	}

	public long getId(){
		return id;
	}
	public void setId( long id){
		this.id = id;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public boolean isSeaView() {
		return seaView;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public boolean getSeaView(){
		return seaView;
	}
	public void setSeaView( boolean seaView){
		this.seaView = seaView;
	}

}
