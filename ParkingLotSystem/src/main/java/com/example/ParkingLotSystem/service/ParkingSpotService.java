package com.example.ParkingLotSystem.service;

import com.example.ParkingLotSystem.entity.ParkingSpot;
import com.example.ParkingLotSystem.entity.SpotSize;
import com.example.ParkingLotSystem.entity.Vehicle;
import com.example.ParkingLotSystem.entity.VehicleType;
import com.example.ParkingLotSystem.exception.NoAvailableSpotException;
import com.example.ParkingLotSystem.repository.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSpotService {

    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    public ParkingSpot createParkingSpot(ParkingSpot parkingSpot) {
        return parkingSpotRepository.save(parkingSpot);
    }

    public static SpotSize getRequiredSpotSize(VehicleType vehicleType) {
        switch (vehicleType) {
            case MOTORCYCLE:
                return SpotSize.MOTORCYCLE;
            case CAR:
                return SpotSize.COMPACT;
            case BUS:
                return SpotSize.LARGE;
            default:
                throw new IllegalArgumentException("Unknown vehicle type");
        }
    }

    @Transactional
    public ParkingSpot assignSpot(Vehicle vehicle) throws NoAvailableSpotException {
        SpotSize requiredSize = getRequiredSpotSize(vehicle.getVehicleType());
        List<ParkingSpot> spots = parkingSpotRepository.findAvailableBySize(requiredSize);

        if (spots.isEmpty()) {
            throw new NoAvailableSpotException("No available parking spot for vehicle type: " + vehicle.getVehicleType());
        }

        ParkingSpot spot = spots.get(0); // basic FIFO
        spot.setOccupied(true);
        parkingSpotRepository.save(spot);

        return spot;
    }
}
