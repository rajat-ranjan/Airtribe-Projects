package com.example.ParkingLotSystem.repository;

import com.example.ParkingLotSystem.entity.Vehicle;
import com.example.ParkingLotSystem.entity.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Vehicle findByLicensePlate(String licensePlate);

    List<Vehicle> findByType(VehicleType type);
}
