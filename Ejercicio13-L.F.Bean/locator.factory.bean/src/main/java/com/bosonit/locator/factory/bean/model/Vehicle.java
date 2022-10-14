package com.bosonit.locator.factory.bean.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Vehicle implements Serializable {
    private static final long serialVersion= 1L;

    private String vehicleName;
    private String vehicleType;
}
