package com.example.CarManagement;

import com.example.CarManagement.entity.Car;
import com.example.CarManagement.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    // Get all cars
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    // Get car by ID
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Optional<Car> car = carService.getCarById(id);
        return car.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create new car
    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        return ResponseEntity.ok(carService.createCar(car));
    }

//    // Update car
//    @PutMapping("/{id}")
//    public ResponseEntity<Car> updateCar(@PathVariable String name, @RequestBody Car car) {
//        Car updatedCar = carService.updateCar(name, car);
//        return updatedCar != null ? ResponseEntity.ok(updatedCar) : ResponseEntity.notFound().build();
//    }

    // Delete car
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

    // Global Search
    @GetMapping("/search")
    public ResponseEntity<List<Car>> searchCars(@RequestParam String searchTerm) {
        return ResponseEntity.ok(carService.searchCars(searchTerm));
    }

    // Pagination and Sorting
    @GetMapping("/pagination")
    public ResponseEntity<List<Car>> getCarsWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return ResponseEntity.ok(carService.getCarsWithPaginationAndSorting(page, size, sortBy));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Car> getCarByName(@PathVariable String name) {
        Optional<Car> car = carService.getCarByName(name);
        return car.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update car by name
    @PutMapping("/name/{name}")
    public ResponseEntity<Car> updateCarByName(@PathVariable String name, @RequestBody Car car) {
        Car updatedCar = carService.updateCar(name, car);
        return updatedCar != null ? ResponseEntity.ok(updatedCar) : ResponseEntity.notFound().build();
    }

    // Delete car by name
    @DeleteMapping("/name/{name}")
    public ResponseEntity<Void> deleteCarByName(@PathVariable String name) {
        carService.deleteCarByName(name);
        return ResponseEntity.noContent().build();
    }
}
