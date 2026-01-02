package com.cjc.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@DynamicUpdate
@XmlRootElement
@Table(name = "Car_Details")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Integer carId;
    @Column(name = "car_name")
    private String carName;
    @Column(name = "car_model")
    private String carModel;
    @Column(name = "car_price")
    private Double carPrice;

    public Integer getCarId() {
        return carId;
    }

    public Car() {
    }

    public Car(Integer carId, String carName, String carModel, Double carPrice) {
        this.carId = carId;
        this.carName = carName;
        this.carModel = carModel;
        this.carPrice = carPrice;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Double carPrice) {
        this.carPrice = carPrice;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carName='" + carName + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carPrice=" + carPrice +
                '}';
    }
}
