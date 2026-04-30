package com.starter.app.Service;

import com.starter.app.Entity.Car;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CarListService {

    private final List<Car> cars = loadCars();

    public List<Car> getAllCars() {
        return cars;
    }

    private Comparator<Car> getComparator(String priority) {

        if (priority == null || priority.isBlank()) {
            // default balanced
            return Comparator
                    .comparingInt(Car::getSafetyRating).reversed()
                    .thenComparingDouble(Car::getMileage).reversed()
                    .thenComparingInt(Car::getPrice);
        }

        switch (priority.toUpperCase()) {

            case "SAFETY":
                return Comparator
                        .comparingInt(Car::getSafetyRating).reversed()
                        .thenComparingDouble(Car::getMileage).reversed();

            case "MILEAGE":
                return Comparator
                        .comparingDouble(Car::getMileage).reversed()
                        .thenComparingInt(Car::getPrice);

            case "BUDGET":
                return Comparator
                        .comparingInt(Car::getPrice)
                        .thenComparingDouble(Car::getMileage).reversed();

            case "FAMILY":
                return Comparator
                        .comparingInt(Car::getSeatingCapacity).reversed()
                        .thenComparingInt(Car::getSafetyRating).reversed();

            default:
                return Comparator
                        .comparingInt(Car::getSafetyRating).reversed()
                        .thenComparingDouble(Car::getMileage).reversed()
                        .thenComparingInt(Car::getPrice);
        }
    }

    public List<Car> filterCars(
            Integer maxBudget,
            String fuelType,
            String bodyType,
            String transmission,
            Double minMileage,
            Integer maxEngineCC,
            Integer minSafetyRating,
            Integer familySize,
            String feature,
            String priority
    ) {
        return cars.stream()
                .filter(car -> car.getPrice() <= maxBudget)
                .filter(car -> fuelType == null || car.getFuelType().contains(fuelType))
                .filter(car -> bodyType == null || car.getBodyType().equalsIgnoreCase(bodyType))
                .filter(car -> transmission == null || car.getTransmission().equalsIgnoreCase(transmission))
                .filter(car -> minMileage == null || car.getMileage() >= minMileage)

                // Safety requirement
                .filter(car -> minSafetyRating == null || car.getSafetyRating() >= minSafetyRating)

                // Family size / seating
                .filter(car -> familySize == null || car.getSeatingCapacity() >= familySize)

                // Engine constraint (optional)
                .filter(car -> maxEngineCC == null || car.getEngineCC() <= maxEngineCC)

                // Feature-based filtering (like "Sunroof", "ADAS")
                .filter(car -> feature == null || feature.isBlank() ||
                        car.getFeatures().stream()
                                .anyMatch(f -> f.toLowerCase().contains(feature.toLowerCase())))

                // 🔥 SMART SORTING (not just cheapest)
                .sorted(getComparator(priority)) // then price

                .limit(3)
                .toList();
    }

    private List<Car> loadCars() {
        return List.of(
                new Car("Maruti Suzuki", "Swift", "Hatchback", 600000, 25.7, "Petrol", "Manual", 1197, 5, 4, 268, List.of("Touchscreen", "LED DRL")),
                new Car("Maruti Suzuki", "Baleno", "Hatchback", 660000, 22.3, "Petrol", "Manual", 1197, 5, 4, 318, List.of("360 Camera", "HUD")),
                new Car("Tata", "Altroz", "Hatchback", 690000, 23.0, "Petrol/Diesel", "Manual", 1199, 5, 5, 345, List.of("5 Star Safety", "Cruise Control")),
                new Car("Hyundai", "i20", "Hatchback", 700000, 20.0, "Petrol", "Automatic", 1197, 5, 4, 311, List.of("Sunroof", "Wireless Charging")),

                new Car("Maruti Suzuki", "Dzire", "Sedan", 680000, 24.1, "Petrol/CNG", "Manual", 1197, 5, 4, 378, List.of("Rear AC Vents")),
                new Car("Honda", "City", "Sedan", 1150000, 18.4, "Petrol", "Automatic", 1498, 5, 5, 506, List.of("ADAS", "Sunroof")),
                new Car("Skoda", "Slavia", "Sedan", 1100000, 19.0, "Petrol", "Manual", 1498, 5, 5, 521, List.of("Ventilated Seats")),

                new Car("Tata", "Punch", "Micro SUV", 600000, 20.0, "Petrol", "Manual", 1199, 5, 4, 366, List.of("High Ground Clearance")),
                new Car("Tata", "Nexon", "SUV", 800000, 24.0, "Petrol/Diesel", "Manual", 1497, 5, 5, 350, List.of("5 Star Safety", "Sunroof")),
                new Car("Hyundai", "Creta", "SUV", 1100000, 21.8, "Petrol/Diesel", "Automatic", 1497, 5, 5, 433, List.of("Panoramic Sunroof", "ADAS")),
                new Car("Kia", "Seltos", "SUV", 1200000, 20.7, "Petrol/Diesel", "Automatic", 1497, 5, 5, 433, List.of("Ventilated Seats")),
                new Car("Mahindra", "Scorpio N", "SUV", 1350000, 15.0, "Diesel", "Manual", 2184, 7, 5, 460, List.of("4x4", "Sony Audio")),
                new Car("Mahindra", "Thar", "SUV", 1000000, 15.2, "Petrol/Diesel", "Manual", 2184, 4, 4, 226, List.of("4x4", "Convertible")),
                new Car("Toyota", "Fortuner", "SUV", 3500000, 14.0, "Diesel", "Automatic", 2755, 7, 5, 480, List.of("Premium SUV", "4x4")),

                new Car("Maruti Suzuki", "Brezza", "SUV", 830000, 19.8, "Petrol", "Automatic", 1462, 5, 4, 328, List.of("HUD")),
                new Car("Maruti Suzuki", "Fronx", "Crossover", 700000, 21.5, "Petrol", "Manual", 1197, 5, 4, 308, List.of("Turbo Engine")),

                new Car("Toyota", "Innova Crysta", "MPV", 1900000, 12.0, "Diesel", "Manual", 2393, 7, 5, 300, List.of("Captain Seats")),
                new Car("Kia", "Carens", "MPV", 1100000, 16.0, "Petrol/Diesel", "Manual", 1497, 7, 4, 216, List.of("3 Row AC")),
                new Car("Maruti Suzuki", "Ertiga", "MPV", 900000, 20.5, "Petrol/CNG", "Manual", 1462, 7, 4, 209, List.of("Affordable 7 seater")),

                new Car("Tata", "Tiago EV", "EV", 800000, 250.0, "Electric", "Automatic", 0, 5, 4, 240, List.of("Fast Charging")),
                new Car("Tata", "Nexon EV", "EV", 1500000, 465.0, "Electric", "Automatic", 0, 5, 5, 350, List.of("Long Range")),
                new Car("MG", "ZS EV", "EV", 2300000, 461.0, "Electric", "Automatic", 0, 5, 5, 470, List.of("Panoramic Sunroof")),

                new Car("Renault", "Kiger", "SUV", 650000, 20.5, "Petrol", "Manual", 999, 5, 4, 405, List.of("Turbo Option")),
                new Car("Nissan", "Magnite", "SUV", 600000, 20.0, "Petrol", "Manual", 999, 5, 4, 336, List.of("Affordable SUV")),
                new Car("Hyundai", "Venue", "SUV", 790000, 24.1, "Petrol/Diesel", "Automatic", 1197, 5, 4, 350, List.of("Connected Car"))
        );
    }
}
