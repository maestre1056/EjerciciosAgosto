package com.bosonit.locator.factory.bean.controller;

import com.bosonit.locator.factory.bean.model.Vehicle;
import com.bosonit.locator.factory.bean.registry.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController {
    @Autowired
    private ServiceRegistry serviceRegistry;

    @PostMapping("vehicle")
    public void processGet(@RequestBody Vehicle vehicle){
        serviceRegistry.getService(vehicle.getVehicleType()).process(vehicle);
    }
}
