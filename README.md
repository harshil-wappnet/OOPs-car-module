# OOPs-car-module
This module provides a basic implementation of Object-Oriented Programming (OOP) concepts using a simple Car class.
## Table of Contents
1. [Introduction](#introduction)
2. [Class Structure](#class-structure)
    - [Car Class](#car-class)
    - [Encapsulation](#encapsulation)
    - [Inheritance](#inheritance)
    - [Abstraction](#abstraction)
    - [Polymorphism](#polymorphism)

## Introduction

The OOPs Car Module demonstrates fundamental Object-Oriented Programming concepts such as inheritance, abstraction, and encapsulation using a basic Car class.

## Class Structure

### Car Class
The `Car` class represents a generic car and extends `Engine` class and implements certain interface such as `SecurityFeature`,`Brakes`,`CarFunctionality`. It contains certain attributes such as `model`,`brand`, `doorlocked` and `style`.

```java
abstract class Car extends Engine implements SecurityFeature, Brakes, CarFunctionality {
    private String brand;
    private String model;
    protected boolean doorsLocked = false;
    protected String style;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void lockDoors() {
        if (!doorsLocked) {
            System.out.println("Doors locked.");
            doorsLocked = true;
        } else {
            System.out.println("Doors are already locked.");
        }
    }

    public void unlockDoors() {
        if (doorsLocked) {
            System.out.println("Doors unlocked.");
            doorsLocked = false;
        } else {
            System.out.println("Doors are already unlocked.");
        }
    }

    public void applyBrakes() {
        System.out.println("Applying brakes.");
    }

    public void releaseBrakes() {
        System.out.println("Releasing brakes.");
    }

    public abstract void driveType();
}
```

### Encapsulation
Encapsulation is demonstrated with private attributes in the `Car` class, and using getter and setterr method for getting or modifying brand name such as `getbrand()` and `setbrand()`.

### Inheritance
The module demonstrates inheritance with the `ElectricCar` class, which inherits from the `Car` class and adds additional attributes and methods specific to electric cars.

>class ElectricCar extends Car {...}
<br>
>class SportsCar extends Car {...}
<br>
>class LuxuryCar extends SportsCar implements EntertainmentSystem {...}

### Abstraction
The concept of abstraction is highlighted through the `Car` abstract class, which defines a common interface for different types of cars.

### Polymorphism
Polymorphism is demonstrated through method overriding in the `ElectricCar` and `SportsCar` classes. The `driveType()` method in ElectricCar, providing a specialized implementation for electric cars.