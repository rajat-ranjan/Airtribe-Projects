package com.example.ParkingLotSystem.controller;

import com.example.ParkingLotSystem.entity.ParkingSpot;
import com.example.ParkingLotSystem.service.ParkingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingSpotController {

    @Autowired
    private ParkingSpotService parkingSpotService;

    //Example method to create a parking spot
    @PostMapping("/parking-spots")
    public ParkingSpot createParkingSpot(@RequestBody ParkingSpot parkingSpot) {
        return parkingSpotService.createParkingSpot(parkingSpot);
    }

    // Additional methods for handling parking spot operations can be added here

}
