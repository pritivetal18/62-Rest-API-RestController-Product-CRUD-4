package com.cjc.rest;

import com.cjc.entity.Car;
import com.cjc.entity.Cars;
import com.cjc.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarService carService;

    // Add Car
    @PostMapping(value = "/addCar", consumes = {"application/json", "application/xml"})
    public String addCar(@RequestBody Car car) {
        carService.saveCar(car);
        return "Car added successfully";
    }

    // Get Car by ID
    @GetMapping(value = "/getCar/{id}", produces = {"application/json", "application/xml"})
    public Car getCar(@PathVariable Integer id) {
        return carService.getCarById(id);
    }

    // Get All Cars
    @GetMapping(value = "/getCars", produces = {"application/json", "application/xml"})
    public List<Car> getCars() {
        return carService.getAllCars();
    }

    //Get All Cars in XML format
    @GetMapping (value = "/getCarsXml", produces = {"application/xml"})
    public Cars getCarsXml() {
        List<Car> carList = carService.getAllCars();
        Cars cars = new Cars();
        cars.setCars(carList);
        return cars;
    }

    // Delete Car
    @DeleteMapping(value = "/deleteCar/{id}")
    public String deleteCar(@PathVariable Integer id) {
        carService.deleteCarById(id);
        return "Car deleted successfully";
    }

    // Update Car (PUT)
    @PutMapping(value = "/updateCar/{id}", consumes = {"application/json", "application/xml"})
    public Car updateCar(@PathVariable Integer id, @RequestBody Car car) {
        return carService.updateCar(id, car);
    }

    // Edit Car (PATCH)
    @PatchMapping(value = "/editCar/{id}", consumes = {"application/json", "application/xml"})
    public Car editCar(@PathVariable Integer id, @RequestBody Car car) {
        return carService.editCarById(id, car);
    }

    // Pagination
    @GetMapping(value = "/getCarByPage", produces = {"application/json", "application/xml"})
    public List<Car> getCarByPage(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize) {
        return carService.getCarByPage(pageNo, pageSize);
    }

    // Sorting by Price
    @GetMapping(value = "/getCarSortByPrice", produces = {"application/json", "application/xml"})
    public List<Car> getCarSortByPrice(
            @RequestParam(defaultValue = "asc") String direction) {
        return carService.getCarSortByPrice(direction);
    }

    // Search by Name
    @GetMapping(value = "/searchCarByName/{name}", produces = {"application/json", "application/xml"})
    public List<Car> searchCarByName(@PathVariable String name) {
        return carService.searchCarByName(name);
    }

    // Filtering by multiple criteria
    @GetMapping(value = "/getCarByFilter", produces = {"application/json", "application/xml"})
    public List<Car> getCarByFilter(
            @RequestParam(required = false) String carName,
            @RequestParam(required = false) String carModel,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice) {

        Map<String, String> filters = new HashMap<>();
        filters.put("carName",carName);
        filters.put("carModel", carModel);

        if (minPrice != null) {
            filters.put("minPrice", String.valueOf(minPrice));
        }
        if (maxPrice != null) {
            filters.put("maxPrice", String.valueOf(maxPrice));
        }

        return carService.getCarByFilter(filters);
    }
}

