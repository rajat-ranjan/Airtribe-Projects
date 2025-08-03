package com.example.ParkingLotSystem.repository;

import com.example.ParkingLotSystem.entity.ParkingTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingTransactionRepository extends JpaRepository<ParkingTransaction, Long> {
    ParkingTransaction findActiveByLicensePlate(String licensePlate);
    // This interface extends JpaRepository to provide CRUD operations for ParkingTransaction entities
    // Additional custom query methods can be defined here if needed
}
