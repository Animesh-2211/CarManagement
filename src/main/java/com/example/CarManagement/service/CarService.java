package com.example.CarManagement.service;


import com.example.CarManagement.entity.Car;
import com.example.CarManagement.repository.CarRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort;


import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;


    public List<Car> getAllCars() {
         return carRepository.findAll();
    }

    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    public Optional<Car> getCarByName(String name) {
        return carRepository.findByName(name);
    }


    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public Car updateCar(String name, Car carDetails) {
      Optional<Car> carOptional = carRepository.findByName(name);
      if(carOptional.isPresent()) {
          Car car = carOptional.get();
          car.setName(carDetails.getName());
          car.setModel(carDetails.getModel());
          car.setYear(carDetails.getYear());
          car.setPrice(carDetails.getPrice());
          car.setColor(carDetails.getColor());
          car.setFuelType(carDetails.getFuelType());
          return carRepository.save(car);
      }

      return null;


    }
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }


    @Transactional
    public void deleteCarByName(String name) {
        carRepository.deleteByName(name);
    }

    public List<Car> searchCars(String keyword) {
        return carRepository.searchCars(keyword);
    }
    // Pagination and Sorting
    public List<Car> getCarsWithPaginationAndSorting(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        return carRepository.findAll(pageable).getContent();
    }
}
