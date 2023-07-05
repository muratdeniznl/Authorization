package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Period{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String roomType;
	private double percentage;
	private LocalDate startDate;
	private LocalDate endDate;

	public Period() {
	}

	public Period(String roomType, double percentage, LocalDate startDate, LocalDate endDate) {
		this.roomType = roomType;
		this.percentage = percentage;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public long getId(){
		return id;
	}
	public void setId( long id){
		this.id = id;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public LocalDate getStartDate(){
		return startDate;
	}
	public void setStartDate( LocalDate startDate){
		this.startDate = startDate;
	}
	public LocalDate getEndDate(){ 
		return endDate;
	}
	public void setEndDate( LocalDate endDate){
		this.endDate = endDate;
	}

}
