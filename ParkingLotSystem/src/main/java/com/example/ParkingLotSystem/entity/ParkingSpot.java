package com.example.ParkingLotSystem.entity;

import jakarta.persistence.*;

@Entity
public class ParkingSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private int floorNumber;

    @Enumerated(EnumType.STRING)
    private SpotSize spotSize; // MOTORCYCLE, COMPACT, LARGE

    private boolean isOccupied;

    public ParkingSpot() {
    }

    public ParkingSpot(Long id, int floorNumber, SpotSize spotSize, boolean isOccupied) {
        this.id = id;
        this.floorNumber = floorNumber;
        this.spotSize = spotSize;
        this.isOccupied = isOccupied;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public SpotSize getSpotSize() {
        return spotSize;
    }

    public void setSpotSize(SpotSize spotSize) {
        this.spotSize = spotSize;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
