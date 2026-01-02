package com.cjc.service;

import com.cjc.entity.Car;

import java.util.List;
import java.util.Map;

public interface CarService {


    void saveCar(Car car);

    Car getCarById(Integer id);

    List<Car> getAllCars();

    void deleteCarById(Integer id);

    Car updateCar(Integer id, Car car);

    Car editCarById(Integer id, Car car);

    List<Car> getCarByPage(Integer pageNo, Integer pageSize);

    List<Car> getCarSortByPrice(String direction);

    List<Car> searchCarByName(String name);

    List<Car> getCarByFilter(Map<String, String> filters);
}
