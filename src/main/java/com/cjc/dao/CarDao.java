package com.cjc.dao;

import com.cjc.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDao extends JpaRepository<Car, Integer> {
    List<Car> findBycarName(String carName);

    List<Car> findByCarNameOrCarModelOrCarPriceBetween(
            String carName,
            String carModel,
            Double minPrice,
            Double maxPrice
    );
}
