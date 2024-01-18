import java.util.Scanner;

interface SecurityFeature {
    void lockDoors();
    void unlockDoors();
}

interface Brakes {
    void applyBrakes();
    void releaseBrakes();
}

interface EntertainmentSystem {
    void playMusic();
    void displayNavigation();
}

interface CarFunctionality {
    void turnOnLights();
    void activateAlarm();
}

class Display {
    public static void displayOn() {
        System.out.println("Display is on.");
    }

    public static void displayOff() {
        System.out.println("Display is off.");
    }
}

class Engine {
    public void start() {
        System.out.println("Starting the car.");
    }

    public void stop() {
        System.out.println("Stopping the car.");
    }
}

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

class ElectricCar extends Car {
    private int batteryCapacity;

    public ElectricCar(String brand, String model, int batteryCapacity) {
        super(brand, model);
        this.batteryCapacity = batteryCapacity;
        this.doorsLocked = true;
    }

    public void driveType() {
        System.out.println("Driving the electric car quietly.");
    }

    public void turnOnLights() {
        System.out.println("Turning side Lights on");
    }

    public void activateAlarm() {
        System.out.println("Alarm activated.");
    }
}

class SportsCar extends Car{
    public SportsCar(String brand, String model, String style) {
        super(brand, model);
        this.style = style;
        this.doorsLocked = true;
    }

    public void style() {
        System.out.println("Style of car " + style);
    }

    public void driveType() {
        System.out.println("Driving the sports car.");
    }

    public void turnOnLights() {
        System.out.println("Turning on headlights.");
    }

    public void activateAlarm() {
        System.out.println("Alarm activated.");
    }
}

class LuxuryCar extends SportsCar implements EntertainmentSystem {
    public LuxuryCar(String brand, String model, String style) {
        super(brand, model, style);
    }

    public void massageSeats() {
        System.out.println("Massaging seats for luxury comfort.");
    }

    public void playMusic() {
        System.out.println("Playing music in the luxury car.");
    }

    public void displayNavigation() {
        System.out.println("Displaying navigation in the luxury car.");
    }
}

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the brand of the electric car: ");
        String electricCarBrand = scanner.nextLine();
        System.out.println("Enter the model of the electric car: ");
        String electricCarModel = scanner.nextLine();
        System.out.println("Enter the battery capacity of the electric car: ");
        int electricCarBatteryCapacity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.println("Enter the brand of the sports car: ");
        String sportsCarBrand = scanner.nextLine();
        System.out.println("Enter the model of the sports car: ");
        String sportsCarModel = scanner.nextLine();
        System.out.println("Enter the style of the sports car: ");
        String sportsCarStyle = scanner.nextLine();

        ElectricCar evCar = new ElectricCar(electricCarBrand, electricCarModel, electricCarBatteryCapacity);
        System.out.println("Brand: " + evCar.getBrand());
        System.out.println("Model: " + evCar.getModel());
        evCar.setBrand("RollsRoyce");
        evCar.unlockDoors();
        evCar.lockDoors();
        evCar.start();
        Display.displayOn();
        evCar.driveType();
        System.out.println("Brand: " + evCar.getBrand());
        evCar.turnOnLights();
        evCar.stop();
        evCar.activateAlarm();

        SportsCar sportCar = new SportsCar(sportsCarBrand, sportsCarModel, sportsCarStyle);
        System.out.println("Brand: " + sportCar.getBrand());
        System.out.println("Model: " + sportCar.getModel());
        sportCar.unlockDoors();
        sportCar.lockDoors();
        sportCar.start();
        Display.displayOn();
        sportCar.driveType();
        sportCar.style();
        sportCar.turnOnLights();
        sportCar.stop();
        Display.displayOff();
        sportCar.unlockDoors();
        

        LuxuryCar luxuryCar = new LuxuryCar("Mercedes", "S-Class", "Sedan");
        System.out.println("Brand: " + luxuryCar.getBrand());
        System.out.println("Model: " + luxuryCar.getModel());
        luxuryCar.unlockDoors();
        luxuryCar.lockDoors();
        luxuryCar.start();
        luxuryCar.driveType();
        luxuryCar.style();
        luxuryCar.turnOnLights();
        luxuryCar.playMusic();
        luxuryCar.displayNavigation();
        luxuryCar.massageSeats();
        luxuryCar.applyBrakes();
        luxuryCar.stop();
        luxuryCar.releaseBrakes();
        luxuryCar.unlockDoors();
    }
}
