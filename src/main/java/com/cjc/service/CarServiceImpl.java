package com.cjc.service;

import com.cjc.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.cjc.dao.CarDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@Service
public class CarServiceImpl implements CarService{
    @Autowired
    private CarDao carDao;

    @Override
    public void saveCar(Car car) {
        carDao.save(car);
    }

    @Override
    public Car getCarById(Integer id) {
        if (carDao.existsById(id)) {
            Car car = carDao.findById(id).get();
            return car;
        }
        return null;
    }

    @Override
    public List<Car> getAllCars() {
        return carDao.findAll();
    }

    @Override
    public void deleteCarById(Integer id) {
        if (carDao.existsById(id)) {
            carDao.deleteById(id);
        } else {
            System.out.println("Car id not found");
        }
    }

    @Override
    public Car updateCar(Integer id, Car car) {
        if (carDao.existsById(id)) {
            Car dbCar = carDao.findById(id).get();
            dbCar.setCarName(car.getCarName());
            dbCar.setCarPrice(car.getCarPrice());
            dbCar.setCarModel(car.getCarModel());
            Car updatedCar = carDao.save(dbCar);
            return updatedCar;
        }
        return null;
    }

    @Override
    public Car editCarById(Integer id, Car car) {
        if (carDao.existsById(id)) {
            Car dbCar = carDao.findById(id).get();

            if (car.getCarName() != null) {
                dbCar.setCarName(car.getCarName());
            }
            if (car.getCarPrice() != null) {
                dbCar.setCarPrice(car.getCarPrice());
            }
            if (car.getCarModel() != null) {
                dbCar.setCarModel(car.getCarModel());
            }
            Car editedCar = carDao.save(dbCar);
            return editedCar;
        }
        return null;
    }

    @Override
    public List<Car> getCarByPage(Integer pageNo, Integer pageSize) {
        Pageable page = PageRequest.of(pageNo, pageSize);
        Page<Car> data = carDao.findAll(page);

        if (data.hasContent()) {
            List<Car> carList = data.getContent();
            return carList;
        }
        return null;
    }

    @Override
    public List<Car> getCarSortByPrice(String direction) {
        Sort sort;
        if (direction != null && direction.equalsIgnoreCase("desc")) {
            sort = Sort.by("carPrice").descending();
        } else {
            sort = Sort.by("carPrice").ascending();
        }
        List<Car> carList = carDao.findAll(sort);
        return carList;
    }

    @Override
    public List<Car> searchCarByName(String name) {
        List<Car> carList = carDao.findBycarName(name);
        return carList;
    }

    @Override
    public List<Car> getCarByFilter(Map<String, String> filters) {

        String carName = filters.get("carName");
        String carModel= filters.get("carModel");

        Double minPrice = filters.get("minPrice") != null ? Double.valueOf(filters.get("minPrice")) : null;

        Double maxPrice = filters.get("maxPrice") != null ? Double.valueOf(filters.get("maxPrice")): null;

        return carDao.findByCarNameOrCarModelOrCarPriceBetween(carName, carModel, minPrice, maxPrice);

    }
}
