package com.starter.app.controller;

import com.starter.app.Entity.Car;
import com.starter.app.Service.CarListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin("*")
public class CarSearchController {

        private final CarListService carListService;

        public CarSearchController(CarListService carListService) {
            this.carListService = carListService;
        }

        @GetMapping("/recommend")
        public List<Car> recommendCars(

                @RequestParam(required = false) Integer maxBudget,
                @RequestParam(required = false) String fuelType,
                @RequestParam(required = false) String bodyType,
                @RequestParam(required = false) String transmission,
                @RequestParam(required = false) Double minMileage,
                @RequestParam(required = false) Integer maxEngineCC,
                @RequestParam(required = false) Integer minSafetyRating,
                @RequestParam(required = false) Integer familySize,
                @RequestParam(required = false) String feature,
                @RequestParam(required = false) String priority

        ) {
            return carListService.filterCars(
                    maxBudget,
                    fuelType,
                    bodyType,
                    transmission,
                    minMileage,
                    maxEngineCC,
                    minSafetyRating,
                    familySize,
                    feature,
                    priority
            );
        }
    }

