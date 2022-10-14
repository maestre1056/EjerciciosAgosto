package com.bosonit.locator.factory.bean.service;

import com.bosonit.locator.factory.bean.model.Vehicle;
import com.bosonit.locator.factory.bean.registry.AdapterService;
import org.springframework.stereotype.Service;

@Service("Motorbike")
public class MotoService implements AdapterService<Vehicle> {
    int numberException=1;
    @Override
    public void process(Vehicle request) {
        System.out.println("Inside Motorbike service- "+request.toString());
    }
}
