package com.starter.app.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private String make;
    private String model;
    private String bodyType;
    private int price;
    private double mileage;
    private String fuelType;
    private String transmission;
    private int engineCC;
    private int seatingCapacity;
    private int safetyRating;
    private int bootSpace;
    private List<String> features;
}
