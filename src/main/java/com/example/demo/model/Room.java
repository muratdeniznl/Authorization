package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    int roomNumber;
    private String roomType;
    int beds;
    boolean smoking;
    boolean disabled;
    boolean cleaned;
    private boolean seaView;

    public Room() {
    }

    public Room(int roomNumber, int beds, boolean smoking, boolean disabled, boolean seaview, String roomType) {
        this.roomNumber = roomNumber;
        this.beds = beds;
        this.smoking = smoking;
        this.disabled = disabled;
        this.cleaned = true;
        this.seaView = seaview;
        this.roomType = roomType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }
    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public boolean isCleaned() {
        return cleaned;
    }

    public void setCleaned(boolean cleaned) {
        this.cleaned = cleaned;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isSeaView() {
        return seaView;
    }

    public void setSeaView(boolean seaView) {
        this.seaView = seaView;

    }

}
