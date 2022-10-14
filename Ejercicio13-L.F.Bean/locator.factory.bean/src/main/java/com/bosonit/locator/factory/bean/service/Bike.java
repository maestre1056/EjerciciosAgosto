package com.bosonit.locator.factory.bean.service;

import com.bosonit.locator.factory.bean.model.Vehicle;
import com.bosonit.locator.factory.bean.registry.AdapterService;
import org.springframework.stereotype.Service;

@Service("Bike")
public class Bike implements AdapterService<Vehicle> {
   // int numberExecution=1;




    @Override
    public void process(Vehicle request) {
        System.out.println("Inside bike service - "+ request.toString());
    }
}
