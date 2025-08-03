package com.example.ParkingLotSystem.repository;

import com.example.ParkingLotSystem.entity.ParkingSpot;
import com.example.ParkingLotSystem.entity.SpotSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingSpotRepository  extends JpaRepository<ParkingSpot, Long> {

    List<ParkingSpot> findAvailableBySize(SpotSize requiredSize);
}