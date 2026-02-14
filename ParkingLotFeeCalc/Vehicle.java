package ParkingLotFeeCalc;

import java.time.LocalDateTime;

public abstract class Vehicle {
    private final String numPlate;
    private final LocalDateTime entryTime;

    @Override
    public String toString() {
        return "Vehicle [numPlate=" + numPlate + ", entryTime=" + entryTime + "]";
    }

    public Vehicle(String numPlate){
        this.numPlate=numPlate;
        this.entryTime= LocalDateTime.now();
    }

    public String getNumPlate() {
        return numPlate;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public abstract double getHourlyRate();
}
