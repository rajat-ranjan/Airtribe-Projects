package com.example.ParkingLotSystem.service;

import com.example.ParkingLotSystem.entity.ParkingSpot;
import com.example.ParkingLotSystem.entity.ParkingTransaction;
import com.example.ParkingLotSystem.entity.Vehicle;
import com.example.ParkingLotSystem.entity.VehicleType;
import com.example.ParkingLotSystem.exception.NoAvailableSpotException;
import com.example.ParkingLotSystem.repository.ParkingSpotRepository;
import com.example.ParkingLotSystem.repository.ParkingTransactionRepository;
import com.example.ParkingLotSystem.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class ParkingTransactionService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ParkingSpotService parkingSpotService;

    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    @Autowired
    private ParkingTransactionRepository transactionRepository;

//    public ParkingTransactionService(VehicleRepository vehicleRepository,
//                                     ParkingSpotRepository parkingSpotRepository,
//                                     ParkingTransactionRepository transactionRepository) {
//        this.vehicleRepository = vehicleRepository;
//        this.parkingSpotRepository = parkingSpotRepository;
//        this.transactionRepository = transactionRepository;
//    }
//
//    private ParkingSpot assignSpot(Vehicle vehicle) {
//        SpotSize requiredSize = SpotSize.fromVehicleType(vehicle.getType());
//        List<ParkingSpot> availableSpots = parkingSpotRepository.findAvailableBySize(requiredSize);
//        if (availableSpots.isEmpty()) {
//            throw new RuntimeException("No available parking spots for " + vehicle.getType());
//        }
//        ParkingSpot spot = availableSpots.get(0);
//        spot.setOccupied(true);
//        return parkingSpotRepository.save(spot);
//    }
//
//    private double calculateFee(ParkingTransaction txn) {
//        // Implement fee calculation logic based on time parked
//        return 0.0; // Placeholder
//    }

    //    Check-In
    public ParkingTransaction checkIn(String licensePlate, VehicleType type) throws NoAvailableSpotException {
        Vehicle vehicle = vehicleRepository.save(new Vehicle(licensePlate, type));
        ParkingSpot spot = parkingSpotService.assignSpot(vehicle);

        ParkingTransaction txn = new ParkingTransaction();
        return transactionRepository.save(txn);
    }

    public ParkingTransaction checkOut(String licensePlate) {
        ParkingTransaction txn = transactionRepository.findActiveByLicensePlate(licensePlate);
        txn.setExitTime(LocalDateTime.now());

        double fee = calculateFee(txn);
        txn.setFee(fee);

// Free the spot
        ParkingSpot spot = txn.getParkingSpot();
        spot.setOccupied(false);
        parkingSpotRepository.save(spot);

        return transactionRepository.save(txn);
    }

    private double calculateFee(ParkingTransaction txn) {
        long minutes = Duration.between(txn.getEntryTime(), txn.getExitTime()).toMinutes();
        VehicleType type = txn.getVehicle().getVehicleType();

        double ratePerHour = switch (type) {
            case MOTORCYCLE -> 1.0;
            case CAR -> 2.5;
            case BUS -> 5.0;
        };

        return Math.ceil(minutes / 60.0) * ratePerHour;
    }
}
