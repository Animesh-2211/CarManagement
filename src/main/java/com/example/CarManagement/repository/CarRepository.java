package com.example.CarManagement.repository;

import com.example.CarManagement.entity.Car;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository  extends JpaRepository<Car,Long> {
  @Query("SELECT c FROM Car c WHERE " +
        "LOWER(c.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
        "LOWER(c.model) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
        "LOWER(c.color) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
        "LOWER(c.fuelType) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
        "CAST(c.year AS string) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
List<Car> searchCars(@Param("searchTerm") String searchTerm);

    Optional<Car> findByName(String name);

    @Transactional
    void deleteByName(String name);
}
