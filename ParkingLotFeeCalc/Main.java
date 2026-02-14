package ParkingLotFeeCalc;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();

        // Create a fixed thread pool with 4 threads
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Submit parking tasks
        executor.submit(() -> {
            Vehicle car1 = new Car("MH12AB1234");
            parkingLotSystem.parkVehicle(car1);
            System.out.println("Parked Car: " + car1.getNumPlate() + " at " + car1.getEntryTime());
        });

        executor.submit(() -> {
            Vehicle car1 = new Car("MH05EH7047");
            parkingLotSystem.parkVehicle(car1);
            System.out.println("Parked Car: " + car1.getNumPlate() + " at " + car1.getEntryTime());
        });

        executor.submit(() -> {
            Vehicle car1 = new Car("MH02EH2234");
            parkingLotSystem.parkVehicle(car1);
            System.out.println("Parked Car: " + car1.getNumPlate() + " at " + car1.getEntryTime());
        });

        executor.submit(() -> {
            Vehicle bike1 = new Bike("MH12XY5678");
            parkingLotSystem.parkVehicle(bike1);
            System.out.println("Parked Bike: " + bike1.getNumPlate() + " at " + bike1.getEntryTime());
        });

        executor.submit(() -> {
            Vehicle bike1 = new Bike("MH03XY5444");
            parkingLotSystem.parkVehicle(bike1);
            System.out.println("Parked Bike: " + bike1.getNumPlate() + " at " + bike1.getEntryTime());
        });

         executor.submit(() -> {
            Vehicle bike1 = new Bike("MH43GF5020");
            parkingLotSystem.parkVehicle(bike1);
            System.out.println("Parked Bike: " + bike1.getNumPlate() + " at " + bike1.getEntryTime());
        });


        // Submit unparking tasks (simulate delay)
        executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2); // simulate parking duration
                parkingLotSystem.unparlVehicle("MH12AB1234");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(3); // simulate parking duration
                parkingLotSystem.unparlVehicle("MH12XY5678");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nCurrently parked cars:");
        List<Vehicle> cars = parkingLotSystem.getParkVehiclesbyType(Car.class);
        cars.forEach(v -> System.out.println(v.getNumPlate() + " - " + v.getEntryTime()));

        System.out.println("\nCurrently parked bikes:");
        List<Vehicle> bikes = parkingLotSystem.getParkVehiclesbyType(Bike.class);
        bikes.forEach(v -> System.out.println(v.getNumPlate() + " - " + v.getEntryTime()));
    }
}