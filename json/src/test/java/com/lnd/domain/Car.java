package com.lnd.domain;

/**
 * @Author lnd
 * @Description
 * @Date 2022/9/1 0:02
 */
public class Car {
    private String brand = null;
    private int doors = 0;

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", doors=" + doors +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }
}

